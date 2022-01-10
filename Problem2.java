//62 Unique Paths
// Time O(m * n)
// Space O(n)
class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(0, 0,  m, n, dp);
    }
    
    private int helper(int i, int j, int m, int n, int[][] dp){
        
        if(i == m || j == n){
            return 0;
        }
        
        if(i == m - 1 && j == n - 1){
            return 1;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int right = helper(i, j + 1, m, n, dp);
        int down = helper(i + 1, j, m ,n, dp);
        
        dp[i][j] = right + down;
        
        return dp[i][j];
    }
}