class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0) {
            return 0;
        }
        // Recursive solution
        // return recurse(m, n, 0, 0);

        // DP Solution with 2D matrix
        // int [][] dp = new int[m + 1][n + 1];
        // dp[m - 1][n] = 1;
        // for(int i = m - 1; i >= 0; i--) {
        //     for(int j = n - 1; j >= 0; j--) {
        //         dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
        //     }
        // }
        // return dp[0][0];

        // DP Solution with 1D matrix
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        return dp[0];
    }

    private int recurse(int m, int n, int row, int col) {
        // base
        if(row == m || col == n) {
            return 0;
        }
        if(row == m - 1 && col == n - 1) {
            return 1;
        }
 
        // logic
        // move in the right direction 
        int case1 = recurse(m, n, row, col + 1);
        // move in the down direction
        int case2 = recurse(m, n, row + 1, col);

        return case1 + case2;
    }
}
