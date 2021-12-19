#TIME, SPACE O(M*N)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        #Bottom up
        dp=[[0]*n]*m
        for i in range(m):
            dp[i][0]=1
            
        for i in range(n):
            dp[0][i]=1
        
        for i in range(1,m):
            for j in range(1,n):
                dp[i][j]=dp[i-1][j]+dp[i][j-1]
                
        return dp[m-1][n-1]
    #Top down
#         dp=[[-1 for i in range(n)] for j in range(m)]
#         print(dp)
        
#         return self.helper(m,n,0,0,dp)


    #Top down
    def helper(self,m,n,i,j,dp):
        pass
        
#         if i>=m or j>=n:
#             return 0
        
#         if i==m-1 and j==n-1:
#             return 1
        
#         if dp[i][j]!=-1:
#             return dp[i][j]
        
#         rp=self.helper(m,n,i,j+1,dp)
#         d=self.helper(m,n,i+1,j,dp)
        
#         dp[i][j]=rp+d
        
#         return dp[i][j]
