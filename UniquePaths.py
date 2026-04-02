# Time Complexity : O(m*n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We apply tabulation but optimize space by using a single array for the current row.
# For each cell, we update the number of paths using the value from the right and current values.
# This gives the total unique paths in dp[0] after processing all rows from bottom to top.

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [0] * n
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                if i == m - 1 or j == n - 1:
                    dp[j] = 1
                else:
                    dp[j] = dp[j] + dp[j+1]

        return dp[0]