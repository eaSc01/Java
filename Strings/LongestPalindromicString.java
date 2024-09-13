class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String p = "";

        for (int i = 0; i<s.length(); i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i + 1);  // even length palindrome

            if (odd.length() > even.length()) {
                if (odd.length() > p.length()) {
                    p = odd;
                }

            } else {
                if (even.length() > p.length()) {
                    p = even;
                }
            }     
        }

        return p;
    }

    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}