// Time Complexity : O(m * n) where m and n are the dimensions of the grid
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using the recursion and memo to traverse through the grid via going right and bottom. Doing the sum of both approaches to find the total paths.
 */
class MemoSolution {
    int[][] memo;

    public int uniquePaths(int m, int n) {
        this.memo = new int[m][n];
        return traverse(m, n, 0, 0);
    }

    private int traverse(int m, int n, int i, int j) {
        if (i == m - 1 || j == n - 1)
            return 1;
        if (memo[i][j] != 0)
            return memo[i][j];

        //traversing bottom and right
        int re = traverse(m, n, i + 1, j) + traverse(m, n, i, j + 1);
        memo[i][j] = re;

        return re;
    }
}


// Time Complexity : O(m * n) where m and n are the dimensions of the grid
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using dp array to start the iteration from last index where number of ways at current cell will be combined ways on the bottom and right. We will overwrite the current dp matrix for getting below value.
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    // last row and column will have only 1 way of traversing via going right and bottom respectively
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j] + dp[j + 1];
                }
            }
        }

        return dp[0];
    }
}