// Time Complexity :Exponential
// Space Complexity :recursive stack mn at worst case
// Did this code successfully run on Leetcode :TLE
// Any problem you faced while coding this :No
class Solution {
    public int uniquePaths(int m, int n) {
        return helper(m, n, 0, 0);
    }

    // explore every path and return sum of valid paths
    public int helper(int m, int n, int i, int j) {
        // edge
        if (i == m - 1 && j == n - 1)
            return 1;
        if (i > m || j > n)
            return 0;
        // logic
        return helper(m, n, i + 1, j) + helper(m, n, i, j + 1);
    }
}

// -----------DP SOLUTION------------------------
// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        // created new dp array
        dp[m - 1][n - 1] = 1;
        // we'll start from destination storing no of paths from each index and will add
        // right and down's
        // no of paths as we can go down and right. at the end will return no of paths
        // stored in starting point
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    continue;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}