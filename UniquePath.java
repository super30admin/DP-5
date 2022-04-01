// Time Complexity : O(m*n) m and n are no. of rows and colums
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will create a dp matrix where we will store the number of paths to reach that location
// possible from that position starting with index (0,0)
// for 1st row and columns there are only one path so we will fill those positions
// For the rest of the locations we can calculate the total possible by adding top and left location values

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++)
            dp[0][i] = 1;
        for(int i = 0; i < m; i++)
            dp[i][0] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}