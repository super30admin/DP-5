

## Problem2: (https://leetcode.com/problems/unique-paths/)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        """
        TC onm
        sc onm
        """

        """optimized soln 1 dp use bottom up approach"""
        if m is None and n is None:
            return 0
        dp = [[0 for _ in range(n + 1)] for k in range(m + 1)]
        print(dp)
        dp[m - 1][n - 1] = 1
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if i == m - 1 and j == n - 1:
                    continue
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1]

        return dp[0][0]

        """
        at every grid we have two choices either to down or righttherefore 2 choices for block 1, 2 for block 2, 2 for block 3 and so on so ...total tc 2^m*n 
        """
#       
#         if m==0 and n==0:
#             return 0
#         return self.helper(m,n, 0, 0)

#     def helper(self, m,n,i,j):
#         ##base case
#         if i==m or j==n:
#             return 0
#         if i==m-1 and j==n-1:
#             return 1


#         ###logic
# #         return self.helper(m,n,i+1,j)+ self.helper(m,n,i, j+1)
#         """solnn 2 omn optimized"""
#         dp=[[None for i in range(n)] for j in range(m)]
#         if m==0 and n==0:
#             return 0
#         return self.helper(m,n, 0, 0)

#     def helper(self, m,n,i,j):
#         ##base case
#         if i==m or j==n:
#             return 0
#         if i==m-1 and j==n-1:
#             return 1

#         ###logic
#         bottom=0
#         if j<n

#         bottom= self.helper(m,n,i+1,j) ###bottom
#         right=self.helper(m,n,i,j+1)###right
#         return bottom +right