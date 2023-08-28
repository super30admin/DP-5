// Time Complexity : O(m*n), where m is the number of rows and n is the number of columns in the grid.
// Space Complexity : O(m*n), where m is the number of rows and n is the number of columns in the grid.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Create a dp array of size m*n, where m is the number of rows and n is the number of columns in the grid.
 * 2. Initialize the last row and last column of the dp array to 1, since there is only one way to reach the last row and last column.
 * 3. For each index in the dp array, add the number of ways to reach the bottom and right cell.
 * 4. Return dp[0][0].
 */

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<n; i++){
            dp[m-1][i] = 1;
        }

        for(int i=0; i<m; i++){
            dp[i][n-1] = 1;
        }

        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }
}