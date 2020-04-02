/*
O(MN) time 
O(MN) space

Approach:
========
1. Update number of possible paths for that square using row value above and column value to the left
2. Once robot reaches m-1, n-1 => that would be total different paths that robot can travel to reach the bottom right
*,

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
         //first column j = 0 -> distinct ways = 1
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        
        // first row i = 0 -> distinct ways = 1
        for(int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
       
        
        // recurrence relation dp[i-1][j] + dp[i][j-1]
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
        
    }
}