""""// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        self.dp = [[0 for i in range(n + 1)] for j in range(m + 1)]
        return self.helper(0, 0, m, n)

    def helper(self, i, j, m, n):
        # base
        if i == m or j == n:
            return 0
        if i == m - 1 and j == n - 1:
            return 1

        # logic
        if self.dp[i][j + 1] == 0:
            self.dp[i][j + 1] = self.helper(i, j + 1, m, n)
        right = self.dp[i][j + 1]

        if self.dp[i + 1][j] == 0:
            self.dp[i + 1][j] = self.helper(i + 1, j, m, n)
        bottom = self.dp[i + 1][j]
        return right + bottom

""""// Time Complexity : O(m*n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# Tabulation
# class Solution:
#     def uniquePaths(self, m: int, n: int) -> int:
#         dp = [1]*n
#         dp[-1] = 1
#         for i in range(m-2, -1, -1):
#             for j in range(n-2, -1, -1):
#                 dp[j] = dp[j] + dp[j+1]
#         return dp[0]


""""// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# Tabulation
# class Solution:
#     def uniquePaths(self, m: int, n: int) -> int:
#         dp=[[0 for i in range(n+1)]for j in range(m+1)]
#         dp[m-1][n-1] = 1
#         for i in range(m-1, -1, -1):
#             for j in range(n-1, -1, -1):
#                 if i == m-1 and j == n-1:
#                     continue
#                 else:
#                     dp[i][j] = dp[i][j+1] + dp[i+1][j]
#         return dp[0][0]

# Recursion-Exhaustive
# class Solution:
#     def uniquePaths(self, m: int, n: int) -> int:
#         return self.helper(0,0,m,n)
#     def helper(self, i, j, m, n):
#         #base
#         if i==m or j==n:
#             return 0
#         if i==m-1 and j==n-1:
#             return 1


#         #logic
#         return self.helper(i, j+1, m, n) + self.helper(i+1, j, m, n)