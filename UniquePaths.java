//Time complexity : O(m*n)
//Space Complexity : O(m*n)
//DP - Bottom - up
class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;

        for(int i = m-1; i>= 0; i--) {
            for(int j = n-1; j>=0;j--) {
                if(i == m-1 && j == n-1) continue;
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}

//Top - Down DP
class UniquePaths {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        this.memo = new int[m+1][n+1];
        return helper(0,0,m,n);
    }

    private int helper(int i, int j, int m, int n) {
        //base case
        if(i == m-1 && j == n-1) return 1;
        if(i == m || j == n) return 0;
        if(memo[i][j] != 0) return memo[i][j];

        //logic
        int case0 = helper(i, j+1, m, n);
        memo[i][j+1] = case0;

        int case1 = helper(i+1, j, m, n);
        memo[i+1][j] = case1;

        return case0+case1;
    }
}