// Time Complexity : O(m * n)
// Space Complexity : O(n * n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

public class UniquePaths {
    private int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        return helper(0,0,m,n);
    }
    private int helper(int i,int j, int m, int n){
        if(i == m -1 && j == n -1) return 1;
        if(i == m || j == n) return 0;
        if(dp[i+1][j] == 0)
            dp[i+1][j] = helper(i+1, j, m, n);
        if(dp[i][j+1] == 0)
            dp[i][j+1] = helper(i, j+1, m, n);
        return dp[i+1][j] + dp[i][j+1]; 
    }
}
