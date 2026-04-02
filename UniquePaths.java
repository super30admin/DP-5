// Time Complexity : O(m * n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We use tabulation DP approach to compute repeated subproblems and store them in a dp array. If the current i, j
are in boundaries, we make the dp value as 1 because they can only move in 1 way.For other cells, robot can
reach by either moving down or using left cell's data. This way, we traverse from top to bottom of the matrix
and return the n-1 cell's value.
 */
class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
         int[] dp = new int[n];
         for(int row = 0 ; row < m ; row++) {
             for(int col = 0 ; col < n ; col++) {
                 if(row == 0 || col == 0)
                     dp[col] = 1;
                 else
                     dp[col] = dp[col] + dp[col - 1];
             }
         }
         return dp[n - 1];
    }
}