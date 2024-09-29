public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        // fill last row last coloumn with 1 as it will have only one path to reach.

        for (int i = 0; i < m; i++) {
            int j = n - 1;
            dp[i][j] = 1;
            System.out.println(dp[i][j]);
        }
        // Fill last row with 1 as it will have only one path
        for (int j = 0; j < n; j++) {
            int i = m - 1;
            dp[i][j] = 1;

        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
