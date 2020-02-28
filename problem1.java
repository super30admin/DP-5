// DP - Accepted
// Time Complexity : O(m x n) 
// Space Complexity : O(m x n) 
// Did this code successfully run on Leetcode : Yes
// Your code here along with comments explaining your approach

class Solution {
    public int uniquePaths(int m, int n) {
        int [][]dp =  new int [m+1][n+1]; //DP array with an extra row and col
        dp[m-1][n-1] = 1; //Setting the start/end as 1
       for(int col = m-1; col >= 0; col--) {
            for(int row = n-1; row >= 0; row--) {
                if(col== m-1 && row == n-1) continue; //out of bound handled
        dp[col][row] = dp[col + 1][row] + dp[col][row + 1]; //add possible ways and set to the cell
      }
    }
    return dp[0][0]; // finally return when reached dest.
    }
}