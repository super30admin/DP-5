// Time Complexity : O(n*m)..where m is the number of rows and n is the number of columns
// Space Complexity :O(n*m) to store the elements in the dp array
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int uniquePaths(int m, int n) {
      
      if(m==1|| n==1 )
      {
        return 1;
      }
      //doing a top down
      int[][] dp = new int[m][n];
      //make the first elements of all the rows of the dp array to 1 as there is only one way to reach those
      for(int i=1;i<n;i++)
      {
        dp[0][i]=1;
      }
      //make the first elements of all elements in the first row of the dp array to 1 as there is only one way to reach those
      for(int j=1;j<m;j++)
      {
        dp[j][0]=1;
      }
      //number of ways to reach a cell is the sum of the cell above and the cell on the left in the dp array
      for(int x=1;x<m;x++)
      {
        for(int y=1;y<n;y++)
        {
          dp[x][y] = dp[x-1][y] + dp[x][y-1];
        }
      }
        return dp[m-1][n-1];
    }
}