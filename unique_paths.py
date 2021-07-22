class Solution:
    
     def uniquePaths(self, m: int, n: int) -> int:       
        """
        TC:O(m*n)
        SC:O(n or m)
        """
        # null
        if m==n==0: return 0
        if n>m: return self.uniquePaths( n, m)
        dp=[1]*n
        for i in range(m-2, -1,-1):
            right=0
            for j in range(n-1,-1,-1):
                dp[j]=dp[j]+right
                right=dp[j]
        return dp[0]
              
        
#         """
#         TC:O(m*n)
#         SC:O(m*n)
#         """
#         if m==n==1:return 1
        
#         dp=[[1]*m]*n
        
#         for row in range(1,len(dp)):
#             for col in range(1, len(dp[0])):
#                 dp[row][col]=dp[row-1][col]+dp[row][col-1]
#         return dp[-1][-1]

      # """
      # Recursive 
      # TC:(O(m*n*m*n))
      # """

#     def uniquePaths(self, m: int, n: int) -> int:
#         return self.helper(m-1,n-1)
#     def helper(self, m, n):
#         if m<0 or n<0:
#             return 0
#         if m==0 or n ==0:
#             return 1
#         return self.helper(m-1, n) + self.helper(m, n-1)

