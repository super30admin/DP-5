"""
Problem : 2

Time Complexity : O(n)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


"""

# Unique Paths

# Approach - 1
# DP Array

class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """        
        dp=[None for _ in range(n)]
        for i in range(n):
            dp[i]=1

        
        for i in range(m-2,-1,-1):
            for j in range(n-2,-1,-1):
                dp[j]=dp[j]+dp[j+1]
        return dp[0]
    

# Approach - 2
# DP Matrix

class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """        

        dp=[[None for _ in range(n)] for _ in range(m)]
        for i in range(n):
            dp[m-1][i]=1
        for i in range(m):
            dp[i][n-1]=1
        
        for i in range(m-2,-1,-1):
            for j in range(n-2,-1,-1):
                dp[i][j]=dp[i+1][j]+dp[i][j+1]
        return dp[0][0]
    
# Approach - 3
# Recursion

class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """        

        return self.helper(0,0,m,n)
    
    def helper(self,i,j,m,n):
        # base

        if i==m-1 and j==n-1:
            return 1
        if i==m or j==n:
            return 0


        # logic
        case1=self.helper(i+1,j,m,n)
        case2=self.helper(i,j+1,m,n)
        return case1+case2