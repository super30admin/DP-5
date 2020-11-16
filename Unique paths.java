// Time Complexity : O(M * N) - as we need to iterate through the whole matrix
// Space Complexity : O(M * N) - As we use a additional dp matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
  public int uniquePaths(int m, int n) {
      int[][] dp = new int[m][n];
      for(int i = 0;i < m;i++){
          dp[i][0] = 1;
      }
      for(int j = 0;j < n;j++){
          dp[0][j] = 1;
      }
      for(int i = 1;i < m;i++){
          for(int j = 1;j < n;j++){
              dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
          }
      }
      return dp[m - 1][n - 1];
  }
}
// Your code here along with comments explaining your approach