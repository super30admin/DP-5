// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[n-1] = 1; // setting bottom right to 1
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = dp[i][j+1] + dp[i + 1][j]; // add down + right
            }
        }
        return dp[0][0];
    }
}



// Time Complexity : O(mxn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[n - 1] = 1; // setting bottom right to 1
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[j] = dp[j] + dp[j + 1]; // add self + right
            }
        }
        return dp[0];
    }
}