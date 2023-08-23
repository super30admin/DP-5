#TC - O(m*n)
#SC - (n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        #tabulation
        dp = [[-1]*n for _ in range(m)]
        for i in range(0,m):
            for j in range(0,n):
                if i == 0 and j == 0:
                    dp[i][j] = 1
                else:
                    up = 0
                    left = 0
                    if i>0: up = dp[i-1][j]
                    if j>0: left = dp[i][j-1]
                    dp[i][j] = up+left
        return dp[m-1][n-1]












       