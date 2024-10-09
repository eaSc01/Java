package Recursion;
import java.util.*;

class SolutionBrute {
    public boolean checkInclusion(String s1, String s2) {
        String a = sort(s1);

        int m = a.length();
        int n = s2.length();

        if (m > n) {
            return false;
        }    

        int left = 0;
        int right = m - 1;

        while (right < n) {
            String temp = sort(s2.substring(left, right + 1));

            if (temp.equals(a)) {
                return true;
            }

            left++;
            right++;
        }

        return false;
    }

    public String sort(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}

class SolutionOptimal {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m > n) {
            return false;
        }    
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        int left = 0, right = 0;

        for (int i = 0; i<s1.length(); i++) {
            char c = s1.charAt(i);
            freq1[c - 'a']++;
        }

        while (right < n) {
            freq2[s2.charAt(right) - 'a']++;
            
            if (right - left + 1 > m) {
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }

            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
            
            right++;
        }

        return false;
    }


}