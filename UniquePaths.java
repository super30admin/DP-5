/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public int uniquePaths(int m, int n) 
    {
        int dp[][] = new int[m+1][n+1];
        return helper(0,0, m, n, dp);
        
    }
    
    private int helper(int i, int j, int m, int n,int dp[][])
    {
        if(i == m-1 && j == n-1)
            return 1;
        
        if(i==m || j == n)
            return 0;
        
        int right = dp[i][j+1];
        
        if(right == 0)
        {
            right = helper(i, j +1, m, n, dp);
            dp[i][j+1] = right;
        }
        
        
        int bottom = dp[i+1][j];
        
        if(bottom == 0)
        {
            bottom = helper(i+1, j, m, n, dp);
            dp[i+1][j] = bottom;
        }
        
        dp[i][j] = right + bottom;
            
        
        return  right + bottom;
    }
}