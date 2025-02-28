class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # T: O(m * n), S: O(m * n)
        # Create a 2D DP table
        dp = [[0 for _ in range(n)] for _ in range(m)]

        # Base cases: there's only one way to reach any cell in the first row or column
        for i in range(m):
            dp[i][0] = 1
        for j in range(n):
            dp[0][j] = 1

        # Fill the DP table
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

        # Return the number of ways to reach the bottom-right cell
        return dp[m - 1][n - 1]
