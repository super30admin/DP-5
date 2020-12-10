#Time Complexity : O(mn)
#Space Complexity : O(mn)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        dp[m-1][n-1] = 1
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                #if we're at the starting point we don't want to change that
                if i == m-1 and j == n-1:
                    continue
                #get summation of both bottom and right
                else:
                    dp[i][j] = dp[i+1][j] + dp[i][j+1]
        return dp[0][0]

#BRUTE FORCE - TC -> O(2^(mn)), SC -> O(mn)
#     def helper(self, i, j, m, n):
#         if i == m-1 and j == n-1:
#             return 1
#         if i > m or j > n:
#             return 0
#         return self.helper(i+1, j, m, n) + self.helper(i, j+1, m, n)

#     def uniquePaths(self, m: int, n: int) -> int:
#         return self.helper(0, 0, m, n)
