#gives time exceeded because many repeted pronlems
#TC: O(2^mn)
#SC: O(mn)

# class Solution(object):
#     def uniquePaths(self, m, n):
#         """
#         :type m: int
#         :type n: int
#         :rtype: int
#         """
#         def helper(i,j,m,n):
#             if i==m-1 and j==n-1: return 1
#             elif i==m or j==n: return 0
#             return helper(i+1,j,m,n) + helper(i,j+1,m,n)
        
#         return helper(0,0,m,n)



#code using the DP matrix 
#Always take an extra row and coloumn for DP solutions because we dont want to process the initial nodes seperately. 
#Will handel them same as other nodes.
#TC: O(m*n)
#SC: O(m*n)
# class Solution(object):
#     def uniquePaths(self, m, n):
#         """
#         :type m: int
#         :type n: int
#         :rtype: int
#         """
#         dp=[[0 for _ in range(n+1)] for _ in range(m+1)]
#         dp[m-1][n-1]=1
#         for i in range(m-1,-1,-1):
#             for j in range(n-1,-1,-1):
#                 if i==m-1 and j==n-1:
#                     continue
#                 dp[i][j]=dp[i+1][j]+dp[i][j+1]
#         return dp[0][0]

#Optimization of the DP array over the space by taking the 1D array
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        dp=[1 for _ in range(n+1)]
        dp[n]=0
        for i in range(m-2,-1,-1):
            for j in range(n-1,-1,-1):
                
                dp[j]=dp[j]+dp[j+1]
        return dp[0]


#code using top-bottom recursion optimization in DFS.
# class Solution(object):
#     def uniquePaths(self, m, n):
#         """
#         :type m: int
#         :type n: int
#         :rtype: int
#         """
#         memo=[[0 for _ in range(n+1)] for _ in range(m+1)]
#         def helper(i,j,m,n):
#             if i==m-1 and j==n-1: return 1
#             elif i==m or j==n: return 0
            
#             right=0
#             if memo[i][j+1]==0:
#                 memo[i][j+1]=helper(i,j+1,m,n)
#             right=memo[i][j+1]
#             bottom=0
#             if memo[i+1][j]==0:
#                 memo[i+1][j]=helper(i+1,j,m,n)
#             bottom=memo[i+1][j]
#             return right + bottom
#         return helper(0,0,m,n)