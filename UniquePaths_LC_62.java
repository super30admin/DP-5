// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO
// (https://leetcode.com/problems/unique-paths/)

// Algo:

/*
 * Go exhaustive to find all paths
 * 
 * NOTE: we don't need to keep track of visited nodes as we are moving in 2 directions R and D, and not in all the 4 directions.
 * So we'll never fall into infinite looped path.
 * 
 * Repeated sub-problems lead to DP
 * 
 * memoize -> tabulate -> space optimize
 */

import java.util.Arrays;

public class UniquePaths_LC_62 {

    /*
     * TLE
     * 
     * TC: O(mn)
     * SC: O(m+n)
     */
    public int uniquePaths_recursion(int m, int n) {
        return paths_recursion(m - 1, n - 1, n);
    }

    private int paths_recursion(int r, int c, int cols) {
        // base
        if (r == 0 && c == 0) {
            return 1;
        }
        // edge
        if (r < 0 || c < 0) {
            return 0;
        }
        // logic
        // up
        int up = paths_recursion(r - 1, c, cols);
        // left
        int left = paths_recursion(r, c - 1, cols);
        return up + left;
    }

    /*
     * TC: O(mn)
     * SC: O(mn) + O(m+n)
     */
    public int uniquePaths_memoize(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return paths_memoize(m - 1, n - 1, n, dp);
    }

    private int paths_memoize(int r, int c, int cols, int[][] dp) {
        // base
        if (r == 0 && c == 0) {
            return 1;
        }
        // edge
        if (r < 0 || c < 0) {
            return 0;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        // logic
        // up
        int up = paths_memoize(r - 1, c, cols, dp);
        // left
        int left = paths_memoize(r, c - 1, cols, dp);
        return dp[r][c] = up + left;
    }

    /*
     * TC: O(mn)
     * SC: O(mn)
     */
    public int uniquePaths_tabulate(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                if (r == 1 && c == 1) {
                    continue;
                }
                // logic
                // up
                int up = dp[r - 1][c];
                // left
                int left = dp[r][c - 1];
                dp[r][c] = up + left;
            }
        }
        return dp[m][n];
    }

    /*
     * TC: O(mn)
     * SC: O(n)
     */
    public int uniquePaths_spaceOptimization(int m, int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                if (r == 1 && c == 1) {
                    continue;
                }
                // logic
                // up
                int up = dp[c];
                // left
                int left = dp[c - 1];
                dp[c] = up + left;
            }
        }
        return dp[n];
    }

}