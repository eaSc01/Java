import java.util.*;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for (String d: dictionary) {
            set.add(d);
        }
        Integer[] dp = new Integer[s.length()];
        return dfs(0, s, set, dp);
    }

    public int dfs(int i, String s, Set<String> set, Integer[] dp) {
        if (i == s.length()) {
            return 0;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        int res = dfs(i + 1, s, set, dp) + 1;

        for (int j = i; j<s.length(); j++) {
            String sub = s.substring(i, j + 1);
            if (set.contains(sub)) {
                res = Math.min(res, dfs(j + 1, s, set, dp));
            }
        }

        dp[i] = res;
        return res;
    }
}