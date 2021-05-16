class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        dp = [[1 for _ in range(n+1)] for _ in range(m+1)]
        print(dp)
        for i in range(1,len(dp)-1):
            for j in range(1,len(dp[0])-1):
                 
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        print(dp)
        return dp[-2][-2]
             
