import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithNoRepeatingChar {
    public int lengthOfLongestSubstringOptimal(String s) {  // tc O(n)
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int n = s.length();

        while (right < n) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }

            map.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    public int lengthOfLongestSubstringPreOptimal(String s) {  // tc O(2n)
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int n = s.length();

        while (right < n) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
