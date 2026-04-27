import java.util.*;

class Solution {

    /**
    Time Complexity : O(M * N)
    Explanation:
    We fill an M x N DP table, computing each cell once.

    Space Complexity : O(M * N)
    Explanation:
    DP table stores number of ways for each cell.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially tried recursion which led to repeated calculations.
    Converted it to DP where each cell depends on:
        - top cell
        - left cell
    Also initialized first row and first column to 1
    since there is only one way to reach those cells.
    */

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // First column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // First row
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill DP
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}