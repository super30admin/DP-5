class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[[0 for _ in range(n)]for __ in range(m)]
        dp[m-1][n-1]=1
        for i in range(m-1,-1,-1):
            dp[i][n-1]=1
        for j in range(n-1,-1,-1):
            dp[m-1][j]=1
            
        for i in range(m-2,-1,-1):
            for j in range(n-2,-1,-1):
                dp[i][j]=dp[i+1][j]+dp[i][j+1]
        return dp[0][0]
        # for i in range(m-1,-1,-1):
        #     for j in range(n-1,-1,-1):
        #         if i==m-1 and j==n-1:
        #             continue
        #         dp[i][j]=dp[i+1][j]+dp[i][j+1]
        # return dp[0][0]