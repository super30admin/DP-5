// Time Complexity : O(m×n)
// Space Complexity : O(m×n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    //aesha
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=m-1; i>=0; i--)
        {
            for(int j =n-1; j>=0; j--)
            {
                if(i==m-1 || j==n-1)
                {
                    dp[i][j]=1;
                }
                else
                {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1]; 
                }
            }
        }
        return dp[0][0]; 
    }
}