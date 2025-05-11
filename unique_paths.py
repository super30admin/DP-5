'''
I went with Tabulation method, although space can be optimized, just dont want to trick myself with additional overhead for now.

TC: O(m*n)
SC: O(m*n)

'''

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:

        dp=[[0 for j in range(n)] for i in range(m)]

        for i in range(0, n):
            dp[m-1][i]=1

        for j in range(0, m):
            dp[j][n-1]=1



        for i in range(m-2, -1,-1):
            for j in range(n-2, -1, -1):
                dp[i][j] = dp[i+1][j]+ dp[i][j+1]




        return dp[0][0]
