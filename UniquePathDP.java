//Time Complexity - O(m*n)
//Space Complexity O(m*n)

class Solution {
    public int uniquePaths(int m, int n) {
      //edge case
      if(m == 0 && n == 0) {
        return 0;
      }
      //dp matrix
      int[][] dp = new int[m+1][n+1];
      //bottom up dp therefore start from finish line 
      dp[m-1][n-1] = 1;
      
      for(int i=m-1;i>=0;i--) {
        for(int j = n-1;j>=0;j--) {
          if(i == m-1 && j == n-1) continue;
          //add already calclated value of subproblem in left colum and top column
          dp[i][j] = dp[i+1][j] + dp[i][j+1];  
        }
      }
      return dp[0][0];
  }
}