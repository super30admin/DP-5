// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        
        for(int i = 0; i <= n; i++) {
            dp[m][i] = 1;
        }
        
        for(int i = m - 1; i > 0; i--) {
            for(int j = n - 1; j > 0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        
        return dp[1][1];
    }
}