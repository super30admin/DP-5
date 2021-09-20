//https://leetcode.com/problems/unique-paths/
/*
Time: O(MN)
Space: O(MN)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;

                else
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j]; // left + top
            }
        }

        return dp[m - 1][n - 1];

    }
}
