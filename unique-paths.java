// Time - O(MN)
// Space - O(MN)

class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        // last row
        for(int j=n-2;j>=0;j--) {
            dp[m-1][j] = 1;
        }
        // last col
        for(int i=m-2;i>=0;i--) {
            dp[i][n-1] = 1;
        }
        
        for(int i=m-2;i>=0;i--) {
            for(int j=n-2;j>=0;j--) {
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        
        return dp[0][0];
        
    }
}
