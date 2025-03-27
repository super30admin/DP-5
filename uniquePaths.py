class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n == 0: return 0

        # create a dp matrix of row m+1 and col n+1 (extra row and cols of all 0's)
        dp = [[0 for i in range(n+1)] for i in range(m+1)]

        # we set the last row and last column to 1 since there's 1 path to reach there
        dp[m-1][n-1] = 1

        print(dp)

        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                # continue since [m-1][n-1] cell already has been assigned value = 1
                if i == m-1 and j == n-1: continue
                dp[i][j] = dp[i+1][j] + dp[i][j+1]

        return dp[0][0]