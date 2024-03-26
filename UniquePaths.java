import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return helperTopDown(0, 0, m, n, memo);

        // return helperBottomUp(m, n);
    }

    // TC: O(m*n)
    // SC: O(m*n)
    public int helperTopDown(int i, int j, int m, int n, int[][] memo) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int rightPaths = 0;
        int downPaths = 0;

        if (i < m - 1) {
            rightPaths = helperTopDown(i + 1, j, m, n, memo);
        }

        if (j < n - 1) {
            downPaths = helperTopDown(i, j + 1, m, n, memo);
        }

        memo[i][j] = rightPaths + downPaths;
        return memo[i][j];

    }

    // TC: O(m*n)
    // SC: O(n)
    public int helperBottomUp(int m, int n) {
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int j = 0; j < m - 1; j++) {
            for (int i = 1; i < n; i++) {
                dp[i] = dp[i] + dp[i - 1];
            }
        }
        return dp[n - 1];
    }

}