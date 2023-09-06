class Problem62 {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0)
            return 0;
    
        int[][] dp = new int[m][n];
        
        for(int j=0;j<n;j++){
            dp[m-1][j]=1;
        }
        
        for(int i=0;i<m;i++){
            dp[i][n-1]=1;
        }
        
        for(int row = m-2; row >= 0; row--) {
            for(int col = n-2; col >= 0; col--) {
                dp[row][col] = dp[row+1][col] + dp[row][col+1];
            }
        }
        
        return dp[0][0];
    }
}
