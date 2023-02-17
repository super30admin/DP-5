class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[[0 for i in range(m)] for i in range(n)]
        print(dp)
        for i in range(n):
            for j in range(m):
                if i==0:
                    dp[0][j]=1
                if j==0:
                    dp[i][0]=1
        # print(dp)
        for i in range(1,n):
            for j in range(1,m):
                dp[i][j]=dp[i][j-1]+dp[i-1][j]
        # print(dp)
        return dp[n-1][m-1]
        