/*
 * 
 * Time compllexity : O(m*n)
 * Space complexity : O(m * n)
 * 
 * 
 * Approach : Every point in grid(except first row and first column) can be reached from top or from left side.
 * 			To keep track of that, we create 2D matrix and to avoid sub problems of calculating number of ways in which each point can be reached, count stored in matrix.
 */

class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        
        for(int i=0; i<n; i++){
            dp[0][i] = 1;
        }
        
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
}