v# // Time Complexity :O(mn)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we implemented three approaches- brute force, topdown with 2d dp matrix, top down with 1 d dp array.
# we are crating a array with all values as 1 and then keep adding the values in the rifht and bottom and update each cell. after the updation is complete for all the cells-
# we return the dp[0]  since it would have the sum of all paths from 0,0 to the m-1,n-1 cell in the amtrix given
class Solution(object):
    # def helper(self,i,j,m,n,memo):
    #     if(i==m or j==n):
    #         return 0
    #     if(i==m-1 and j==n-1):
    #         return 1
    #     # logic
    #     case1,case2=0,0
    #     if(j<n-1):
    #         if(memo[i][j+1]==0):
    #             memo[i][j+1]=self.helper(i,j+1,m,n,memo)
    #         case1=memo[i][j+1]
    #     if(i<m-1):
    #         if(memo[i+1][j]==0):
    #             memo[i+1][j]=self.helper(i+1,j,m,n,memo)
    #         case2=memo[i+1][j]
    #     return case1+case2
  

    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        # bf: O(2^(m+n))
        # return self.helper(0,0,m,n)

        # top down dp O(mn)
        # memo=[[0 for i in range(n)]for k in range(m)]
        # return self.helper(0,0,m,n,memo)

        # bottom-up dp O(mn)O(mn)
        dp=[[0] * n for i in range(m)]
        for j in range(n):
            print(j)
            dp[m-1][j]=1
        for i in range(m):
            dp[i][n-1]=1
        for i in range(m-2,-1,-1):
            for j in range(n-2,-1,-1):
                dp[i][j]=dp[i+1][j]+ dp[i][j+1]
        return dp[0][0]