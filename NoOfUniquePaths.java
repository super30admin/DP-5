// Time Complexity :O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
//Using bottom up dp approach dp[i][j] = rightcell + downcell
// note: mark dp[m-1][n-1] =1 also dp should be of m+1,n+1 size


class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m+1][n+1];
        
        dp[m-1][n-1] =1;
        
        for(int i = m-1;i>=0;i--)
        {
            for(int j = n-1;j>=0;j--)
            {
                if(i==m-1 && j==n-1) continue;
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        
        return dp[0][0];
    }
}