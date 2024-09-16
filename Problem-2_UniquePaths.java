// Time Complexity :
//      Time complexity of this solution is m x n
//
// Space Complexity :
//      O(1) as we are not using any extra space.
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int uniquePaths(int m, int n) {
        //edge case
        if(m==0 && n==0) return 0;
        //we create a matrix which is of size 1 more for rows and columns to store 0s
        //we shall then proceed from the bottom most row
        //and calculate sum for each cell for its adjacent bottom cell and right cell
        //we need extra row and column to store values in mth row and nth coumn
        //which we initially want as 0
        //logic
        int [][] dp = new int [m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(i == m-1 && j == n-1) continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}