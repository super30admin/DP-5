TC: O(m*n)
SC: O(m*n)
class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        
        for(int i=0;i<m;i++) {
            dp[i][0] = 1;
        }
        
         for(int i=0;i<n;i++) {
            dp[0][i] = 1;
        }
        
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
        // return helper(0, 0, m, n);   
    }
    
    private int helper(int i, int j, int m, int n) {
        //base 
        if(i == m || j == n) return 0;
        if(i == m-1 && j==n-1) {
            return 1;
        }
        
        //logic
        return helper(i, j+1, m, n) + helper(i+1, j, m, n);
        
    }
}
