# Time Complexity : O(m * n)
# Space Complexity : O(m * n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use recursion + memoization (top-down DP).
# From each cell (i, j), we can reach it either from the top (i-1, j)
# or from the left (i, j-1).
# Base case: (0,0) has 1 way.
# Store results in dp to avoid recomputation.
# Final answer is number of ways to reach (m-1, n-1).

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:

        def can_reach(i,j,dp):
            if i == 0 and j == 0:
                return 1 
            if dp[i][j] != -1:
                return dp[i][j]
            up,left = 0,0
            if i > 0:
                up = can_reach(i - 1,j,dp)
            if j > 0:
                left = can_reach(i,j - 1,dp)
            dp[i][j] = up + left
            return dp[i][j]

        res = 0
        memo = [[-1 for i in range(n)] for _ in range(m)]
        return can_reach(m - 1,n - 1,memo)
        