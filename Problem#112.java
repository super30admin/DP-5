// Unique Paths

// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

// DP - top down

class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        dp[m-1][n-1] = 1;
        return helper(0, 0, m, n);
    }
    private int helper(int i, int j, int m, int n){
        //base
        if(i == m-1 && j == n-1)
            return 1;
        //logic
        int right = 0;
        if(j+1 < n){
            if(dp[i][j+1] == 0) //If right is not already found
                dp[i][j+1] = helper(i, j+1, m, n);
            right = dp[i][j+1];
        }
        int down = 0;
        if(i+1 < m){
            if(dp[i+1][j] == 0) //If bottom is not already found
                dp[i+1][j] = helper(i+1, j, m, n);
            down = dp[i+1][j];
        }
        return right + down;
    }
}

// DP - bottom up

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(i == m - 1 && j == n-1){
                    continue;
                }
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}