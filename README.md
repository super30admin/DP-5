# DP-5

## Problem1: (https://leetcode.com/problems/word-break/)


## Problem2: (https://leetcode.com/problems/unique-paths/)
//Time Complexity = O(m*n)
//Space Complexity = O(m*n)
class Solution {
    public int uniquePaths(int m, int n) {
       
        int[][] dp = new int[m][n];
        
        
        for(int i = 0; i < dp.length; i++)
        {
            dp[i][0] = 1; 
        }
        
        for(int j = 0; j < dp[0].length; j++)
        {
            dp[0][j] = 1;
        }
        
        for(int i = 1; i < dp.length; i++){
            
            for(int j = 1; j < dp[0].length; j++){
                
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
                
            }
        }
        
        return dp[m-1][n-1]; 
    }
}