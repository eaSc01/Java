package LeetCode;

class Solution {
    public String shortestPalindrome(String s) {
        // Define a modulus value for hashing
        long mod = 100000007;
        // Hash values for forward and reverse strings
        long fh = 0; // Forward hash
        long rh = 0; // Reverse hash
        // Base value for polynomial rolling hash
        int base = 26;
        long power = 1; // Variable to store the current power of the base
        int idx = -1; // Index to track the last matching hash

        // Loop through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // Calculate character value (1-indexed)
            int ch = s.charAt(i) - 'a' + 1;

            // Update the forward hash
            fh = ((fh * base) + ch) % mod;
            // Update the reverse hash
            rh = (rh + (ch * power)) % mod;
            // Update the power for the next character
            power = (power * base) % mod;

            // Check if the forward and reverse hashes match
            if (fh == rh) {
                // Update the index if they match
                idx = i;
            }
        }

        // Get the remaining suffix after the longest palindromic prefix
        String remainingSuffix = s.substring(idx + 1);
        // Reverse the remaining suffix
        StringBuilder sb = new StringBuilder(remainingSuffix).reverse();
        // Append the original string to the reversed suffix and return
        return sb.append(s).toString();
    }
}
