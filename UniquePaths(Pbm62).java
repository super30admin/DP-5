/* 
    Algorithm:
        1. We know that the finish cell  can be reached in 1 way from itself.
        2. For every other cell, add right cell value and down cell value.
        3. Return the start cell value
        
        
        Time Complexity: O(mn)
        Space Complexity: O(mn)
*/


class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m+1][n+1];
        
        dp[m-1][n-1]=1;
        
        for(int i = m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(i==m-1 && j==n-1)
                    continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
       
        
        return dp[0][0];
    }
    
}