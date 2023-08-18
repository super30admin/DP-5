// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    private int dp[][];

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        return helper(0, 0, m, n);
    }

    private int helper(int i, int j, int m, int n) {
        if (i == m || j == n)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;
        int case1 = 0;
        if (j < n - 1) {
            if (dp[i][j + 1] == 0) {
                dp[i][j + 1] = helper(i, j + 1, m, n);
            }
            case1 = dp[i][j + 1];
        }
        int case2 = 0;
        if (i < m - 1) {
            if (dp[i + 1][j] == 0) {
                dp[i + 1][j] = helper(i + 1, j, m, n);
            }
            case2 = dp[i + 1][j];
        }
        return case1 + case2;
    }
}