// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes




class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(m, n, dp);
    }

    private int helper(int m, int n, int[][] dp) {
        if(m == 1 && n == 1) {
            return 1;
        } 

        if(dp[m][n] != -1) {
            return dp[m][n];
        }

        int count = 0;
        if(m >= 1) {
            count += helper(m-1, n, dp);
        }
        
        if(n >= 1) {
            count += helper(m, n-1, dp);
        }

        return dp[m][n] = count;
    }
}

