/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m*n)
* 
* Space Complexity: O(m*n)
* 
*/

public class UniquePathsMemo {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return helper(m - 1, n - 1, dp);
    }

    private int helper(int row, int col, int[][] dp) {
        if (row == 0 && col == 0) {
            return 1;
        }

        if (row < 0 || col < 0) {
            return 0;
        }

        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int up = helper(row - 1, col, dp);
        int left = helper(row, col - 1, dp);

        dp[row][col] = up + left;

        return dp[row][col];
    }
}