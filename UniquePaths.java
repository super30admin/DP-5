// TC: O(M*N) , M, N-> dimensions of grid
// SC: O(M*N)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // fill the first column with 1 as there is 1 way ( downward direction) to reach these cells
        for (int i = 0; i < m; i++)
        {
           dp[i][0] = 1;
        }
        // fill the first row with 1 as there is 1 way ( right direction) to reach these cells
        for (int j = 0; j < n; j++)
        {
          dp[0][j] = 1;
        }
        
        for ( int i = 1; i < m; i++)
        {
            for ( int j = 1; j < n; j++)
            {
                // no. of ways to reach current cell =  no. of ways to reach top cell + no. of ways to reach left cell
                dp[i][j] = dp[i-1][j] + dp[i][j-1];     
            }
        }
        return dp[m-1][n-1];
    }
}
