// https://leetcode.com/problems/unique-paths/

// Recurrsion
// Time Complexity: O(2^(m+n))
// Space Complexity: O(m+n)

// Memoization
// Time Complexity: O(m*n)
// Space Complexity: O(m*n)

// DP (Bottom-up)
// Time Complexity: O(m*n)
// Space Complexity: O(m*n)

class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        // this.memo = new int[m][n];
        // return helper(0, 0, m, n);

        int[][] dp = new int[m][n];

        // Base case: when either row or column is 1,
        // there is only one way to reach the end
        for (int i = 0; i < m; i++)
            dp[i][n - 1] = 1;
        for (int i = 0; i < n; i++)
            dp[m - 1][i] = 1;

        // Fill the DP table bottom-up
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0];
    }

    private int helper(int r, int c, int m, int n) {
        //base
        if(r == m || c == n ) return 0;

        if(r == m-1  || c == n-1) return 1;

        if(memo[r][c] != 0) return memo[r][c];
        //logic
        int right = helper(r, c+1, m, n);

        int down = helper(r+1, c, m, n);

        memo[r][c] = right+down;
        return memo[r][c];
    }

}

