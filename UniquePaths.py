"""
//Time Complexity : O(m * n)
// Space Complexity :O(m * n) 
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        #Dp Approach
        #T.C = 0(m*n)
        #S.C= O(m*n)
        
        if(m==0 or n == 0):
            return 0
        dp = [[0 for j in range(0,n)]for i in range(0,m)]
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if(i==m-1 or j == n-1):
                    dp[i][j] = 1
                    continue
                dp[i][j] = dp[i+1][j] + dp[i][j+1]
        return dp[0][0]
                
    #     #T.C = 2^(m*n)
    #     #S.C = 
    #     if m == 0 and n== 0:
    #         return 0
    #     return self.helper(0,0,m,n)
    # def helper(self,row,col,m,n):
    #     if(m== row or n == col):  #invalid path
    #         return 0
    #     if(row == m -1 and col ==  n -1 ):
    #         return 1
    #     return self.helper(row + 1,col,m,n) + self.helper(row,col+1,m,n)
        
