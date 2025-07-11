"""
I used bottom-up DP and created a 2D array `dp` where each cell stores the number of unique paths to that point If both row and column > 0, paths = top + left; else, it's 1 since it's the edge.  
The answer is stored in the bottom-right cell `dp[m-1][n-1]`
Time Complexity: O(mn)
Space Complexity: O(mn)
"""
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:

        dp = [[0] * n for _ in range(m)]

        for i in range(m):
            for j in range(n):
                if i > 0 and j > 0:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                else:
                    dp[i][j] = 1

        return dp[m - 1][n - 1]