# Time Complexity : O(m*n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach

# Tabulation
# TC: O(m*n); SC: O(n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [1] * n
        dp[-1] = 1
        for i in range(m - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                dp[j] = dp[j] + dp[j + 1]
        return dp[0]


print(Solution().uniquePaths(4, 4))


# Tabulation
# TC: O(m*n); SC: O(m*n)
# class Solution:
#     def uniquePaths(self, m: int, n: int) -> int:
#         dp = []
#         for i in range(m+1):
#             dp.append([0]*(n+1))
#         for i in range(m-1, -1, -1):
#             for j in range(n-1, -1, -1):
#                 if i == m-1 and j == n-1:
#                     dp[m-1][n-1] = 1
#                 else:
#                     dp[i][j] = dp[i][j+1] + dp[i+1][j]
#         return dp[0][0]
#
#
# print(Solution().uniquePaths(4, 4))

# memorization
# TC: O(m*n); SC: O(m*n)
# class Solution:
#     def helper(self, m, n, i, j):
#         # base
#         if i == m or j == n:
#             return 0
#         if i == m-1 and j == n-1:
#             return 1
#         # logic
#         if self.dp[i][j+1] == 0:
#             self.dp[i][j+1] = self.helper(m, n, i, j+1)
#         right = self.dp[i][j+1]
#         if self.dp[i+1][j] == 0:
#             self.dp[i+1][j] = self.helper(m, n, i+1, j)
#         down = self.dp[i+1][j]
#         return right + down
#
#     def uniquePaths(self, m: int, n: int) -> int:
#         self.dp = []
#         for i in range(m+1):
#             self.dp.append([0]*(n+1))
#         return self.helper(m, n, 0, 0)
#
#
# print(Solution().uniquePaths(4, 4))


# Exhaustive.
# TC - exponential.
# class Solution:
#     def helper(self, m, n, i, j):
#         # base
#         if i == m or j == n:
#             return 0
#         if i == m-1 and j == n-1:
#             return 1
#         # logic
#         right = self.helper(m, n, i, j+1)
#         down = self.helper(m, n, i+1, j)
#         return right + down
#
#     def uniquePaths(self, m: int, n: int) -> int:
#         return self.helper(m, n, 0, 0)
#
#
# print(Solution().uniquePaths(4, 4))
