class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = 1; // only one way to reach any value in the top row
                } else if (j == 0) {
                    dp[i][j] = 1; // only on way to reach cells in the first column
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]; // the number of ways to the previous 2 possible cells
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
}

//Time complexity : O(M*N)
//Space complexity : O(M*N)
