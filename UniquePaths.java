// TC = O(M*N)
// SC = O(M*N)
class UniquePaths{

    int[][] dp;
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1; // Starting point.
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                if(i==m-1 && j==n-1) continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1]; //travesring row and clom element.
            }
        }
        return dp[0][0];
    }
}
    