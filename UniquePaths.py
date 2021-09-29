"""
Time Complexity : O(m x n) where m and n are size of grids given 
Space Complexity : O(m x n) where m and n are size of grids given 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n == 0:
            return 0
        dp = [[1]*n for i in range(m)]
        print(dp)
        # While we traverse through the dp row and column wise from bottom up we 
        # add the cross elements as the dp matrix grows. If the i is equal m -1 and
        # j = n - 1 we simply continue
        for i in range(m - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                if i == m - 1 or j == n - 1:
                    continue
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1]
        return dp[0][0]