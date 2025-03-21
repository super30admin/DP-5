
class UniquePath {
    // Time Complexity: O(2^(m+n)) where m is the number of rows and n is the number of columns
    public int uniquePathsRecursion(int m, int n) {
        return helper(0, 0, m, n);
    }

    private int helper(int i, int j, int m, int n){
        // base
        if(i >= m || j >= n){
            return 0;
        }

        if(i == m-1 && j == n-1){
            return 1;
        }

        // logic
        return helper(i+1, j, m, n) + helper(i, j+1, m, n);
    }

    // Time Complexity: O(m*n) where m is the number of rows and n is the number of columns
    public int uniquePathsMemo(int m, int n) {
        int[][] memo = new int[m][n];
        return helperMemo(0, 0, m, n, memo);
    }

    private int helperMemo(int i, int j, int m, int n, int[][] memo){
        // base
        if(i >= m || j >= n){
            return 0;
        }

        if(i == m-1 && j == n-1){
            return 1;
        }

        if(memo[i][j] != 0){
            return memo[i][j];
        }

        // logic
        int bottom = helperMemo(i+1, j, m, n, memo);
        int right = helperMemo(i, j+1, m, n, memo);
        memo[i][j] = bottom + right;
        return bottom + right;
    }

    // Time Complexity: O(m*n) where m is the number of rows and n is the number of columns
    // Space Complexity: O(m*n) where m is the number of rows and n is the number of columns
    public int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for(int i = 1; i < m; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < n; i++){
            dp[0][i] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
