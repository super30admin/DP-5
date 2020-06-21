// Time Complexity : O(n) where n is the number of elements in the matrix
// Space Complexity : O(n) where we have a dp array to store the intermediate results
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: We mark the last cell as 1. We determine the other cells using the patter next row and
next columns (i+1 and j+1). We sum them up to find the number of ways that the particular cell can be reached. We mark the number on that cell. We 
use that result further to calculate the number of ways to reach the further cells from bottom till we reach at the top (0,0).
*/

// DP APPROACH
class Solution {
    public int uniquePaths(int m, int n) {
       int[][] dp = new int[m+1][n+1];
       dp[m-1][n-1] = 1;                                                                    //  Mark the last cell as 1
       for(int i = m-1; i >=0 ; i--){
           for(int j = n-1; j>=0; j--){
               if(i == m-1 && j == n-1) continue;                                               // If I am at the last cell, skip the sum of 0
               dp[i][j] = dp[i+1][j] + dp[i][j+1];                                      // Number of ways I can reach a cell using the down and right directions result
           }
       }
      return dp[0][0];                                                                  // Return the topmost cell number
    }
}

// BRUTE FORCE
class Solution {
    int M;
    int N;
    public int uniquePaths(int m, int n) {
       M = m;
       N = n;
       return dfs(0, 0);                                                                                // Start the journey
    }
    private int dfs(int i, int j){
        if(i < 0 || j < 0 || i == M || j == N){return 0;}                                                           // Out of bounds
        if((i == M-1)&&(j==N-1)){return 1;}                                                             // Reached the destination
        int path1 = dfs(i+1, j);                                                                            // Go down
        int path2 = dfs(i, j + 1);                                                                      // GO right
        return path1+path2;                                                                         // Number of ways to reach the cell
    }
}