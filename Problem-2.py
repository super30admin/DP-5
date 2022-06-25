class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[1 for i in range(n)]
        
        for i in range(m-2,-1,-1):
            right=0
            for j in range(n-1,-1,-1):
                dp[j]=dp[j]+right
                right=dp[j]
                
        return dp[0]