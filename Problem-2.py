# Time Complexity : O(m * n), m = number of rows, n = number of columns
# Space Complexity : O(m * n) for DP table (can be optimized to O(n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Use dynamic programming where dp[i][j] = number of unique paths to cell (i,j).
# 2. dp[i][j] = dp[i-1][j] + dp[i][j-1], as robot can only move right or down.
# 3. Initialize first row and first column to 1.
# 4. Return dp[m-1][n-1].

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1] * n for _ in range(m)]
        
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        
        return dp[m-1][n-1]