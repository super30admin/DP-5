class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[[0]*n for row in range(m)]
        dp[0][0]=1
        for row in range(1,m):
            dp[row][0]=1
        for col in range(1,n):
            dp[0][col]=1
        for row in range(1,m):
            for col in range(1,n):
                dp[row][col]=dp[row][col-1]+dp[row-1][col]
        return dp[-1][-1]
		
#TC --> O(m*n)
#SC --> O(m*n)

