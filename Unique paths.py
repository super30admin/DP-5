class Solution:
    def uniquePaths(self, m, n) :
        if m == 0 and n == 0:
            return 0
        dp = [[0 for i in range(n + 1)] for j in range(m + 1)]

        dp[0][0] = 1

        for i in range(0, m):
            for j in range(0, n):
                if i == 0 and j == 0:
                    continue
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

        print(dp)
        return dp[m - 1][n - 1]
