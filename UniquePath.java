//https://leetcode.com/problems/unique-paths/
// Time Complexity :O(m*n)  
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public int uniquePaths(int m, int n) {
           int[] dp=new int[n+1];
        dp[n-1]=1;
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(i==m-1 && j==n-1) continue;
                dp[j]=dp[j]+dp[j+1];
            }
        }
        return dp[0];    
        
    }
    public int spacemn(int m,int n)
    {
        int[][] dp=new int[m+1][n+1];
        dp[m-1][n-1]=1;
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(i==m-1 && j==n-1) continue;
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];  
    }
}