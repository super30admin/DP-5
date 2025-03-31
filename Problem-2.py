'''
    Time Complexity: O(mn)
    Space Complexity: O(n)
'''
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for _ in range(n)] for _ in range(2)]

        dp[0][0] = 1
        dp[1][0] = 1

        for i in range(1, n):
            dp[0][i] = 1

        for i in range(1, m):
            for j in range(1, n):
                dp[1][j] = dp[0][j] + dp[1][j-1]

            dp[0] = dp[1]

        return dp[1][n-1] if m > 1 else dp[0][n-1]
