import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        generatePartitions(0, s, new ArrayList<>(), ans);
        return ans;
    }

    public void generatePartitions(
        int i, 
        String s, 
        List<String> part, 
        List<List<String>> ans
    ) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j<s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                part.add(s.substring(i, j + 1));
                generatePartitions(j + 1, s, part, ans);
                part.remove(part.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}