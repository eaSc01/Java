public class UniquePathsGrid {
    public static void main(String[] args) {
        System.out.println(uniquePaths(5, 5));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return countPathsHashed(0, 0, m, n, dp);
    }

    public static int countPathsHashed(int row, int col, int m, int n, int[][] dp) {
        if (row >= m || col >= n) {
            return 0;
        }

        if (row == (m - 1) && col == (n - 1)) {
            return 1;
        }

        if (dp[row][col] != 0) {
            return dp[row][col] - 1;
        }

        int bottomPaths = countPathsHashed(row + 1, col, m, n, dp);
        int rightPaths = countPathsHashed(row, col + 1, m, n, dp);
        dp[row][col] = bottomPaths + rightPaths + 1;
        return dp[row][col] - 1;
    }

    public int calculatePathsBrute(int row, int col, int m, int n) {
        if (row >= m || col >= n) {
            return 0;
        }

        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        int bottomPaths = calculatePathsBrute(row + 1, col, m, n);
        int rightPaths = calculatePathsBrute(row, col + 1, m, n);
        return bottomPaths + rightPaths;
    }

    public int uniquePathsOptimal(int m, int n) {
        int N = m + n - 2; // total possible paths
        int r = n - 1; // either n - 1, or m - 1 (row - 1, col - 1) may give unique paths of
                       // combination

        int res = 1;

        for (int i = 1; i <= r; i++) {
            res = (res * (N - r + i)) / i; // combination shortcut, refer to Pascals Triangle for details
        }

        return res;
    }
}
