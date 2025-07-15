# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0] * n for _ in range(m)]

        for i in range(m):
            for j in range(n):
                if i>0 and j>0:
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]
                else:
                    dp[i][j] = 1
        return dp[m-1][n-1]

    
# Time Complexity: O(m*n)
# Space Complexity: O(n)

# class Solution:
#     def uniquePaths(self, m: int, n: int) -> int:
#         dp = [1] * n
#         for i in range(1, m):
#             for j in range(1, n):
#                 dp[j] += dp[j-1]
#         return dp[-1]