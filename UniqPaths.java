public class UniqPaths {

    // DP approach
    // TC : O(m * n)
    // SC : O(m * n)
    /*
    for m = 3, n = 4
    dp matrix would be ->
    10  6  3  1  0
    4   3  2  1  0
    1   1  1  1  0
    0   0  0  0  0
     */
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;

        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = 1;

        for(int i = m - 1; i>=0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 && j == n - 1) continue; // otherwise, it will make this filed as 0
                                                        // we want it to be 1 only
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1]; // each value at i,j represents
                                                            // the number of paths to reach bottom-right corner
                                                                    // from that location
            }
        }
        return dp[0][0];
    }
}
