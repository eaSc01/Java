package LeetCode;

import java.util.*;

public class LengthOfLongestCommonPrefix {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> set = new HashSet<>();

        for (int num : arr1) {
            String str = Integer.toString(num);
            String prefix = "";

            for (char ch : str.toCharArray()) {
                prefix += ch;
                set.add(prefix);
            }
        }

        int max = 0;
        for (int num : arr2) {
            String str = Integer.toString(num);
            String prefix = "";

            for (char ch : str.toCharArray()) {
                prefix += ch;
                if (set.contains(prefix)) {
                    max = Math.max(prefix.length(), max);
                }
            }
        }

        return max;
    }
}