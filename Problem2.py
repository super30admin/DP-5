# 62. Unique Paths
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0]*n for _ in range(m)]
        dp[m-1][n-1] = 1

        for i in range(0,n-1):
            dp[m-1][i] = 1

        for j in range(0,m-1):
            dp[j][n-1] = 1

        for i in range(m-2,-1,-1):
            for j in range(n-2,-1,-1):
                dp[i][j] = dp[i+1][j] + dp[i][j+1]

        return dp[0][0]
        