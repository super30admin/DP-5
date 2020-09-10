class Solution(object):
    def uniquePaths(self, m, n):
        dp=[[1]*n for i in range(m)]
        for row in range(1,m):
            for col in range(1,n):
                dp[row][col]=dp[row-1][col]+dp[row][col-1]
        return dp[m-1][n-1]
#Time-Complexity:O(M*N)
#Space-Complexity:O(M*N)