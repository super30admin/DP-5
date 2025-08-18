// Time Complexity : O(m*n)
// Space Complexity : O(m*n) can be updated to 1D matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : start at the bottom right cell. There only one way to reach it from itself. For every other number of ways
/// is equal to number of ways from right cell + number of ways from below cell
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        dp[m-1][n-1] = 1;
        for(int i = m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    continue;
                }
                int right = 0, bottom = 0;
                if(j!=n-1)
                    right = dp[i][j+1];
                if(i!=m-1){
                    bottom = dp[i+1][j];
                }
                dp[i][j] = right + bottom;
            }
        }
        return dp[0][0];
    }
}