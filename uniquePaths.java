// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


public class uniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return helper(0, 0, m, n, memo);
    }

    private int helper(int i, int j, int m, int n, int[][] memo) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (i >= m)
            return 0;
        if (j >= n)
            return 0;

        if (memo[i][j] != 0)
            return memo[i][j];

        memo[i][j] = helper(i, j + 1, m, n, memo) + helper(i + 1, j, m, n, memo);
        return memo[i][j];
    }
}
