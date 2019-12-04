''' 
leetcode - 62 - unique paths - https://leetcode.com/problems/unique-paths/
time complexity - O(2^N*2)
approach - recursive approach

'''
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        i=0
        j=0
        return self.helper(0,0,m,n)
    
    def helper(self,i,j,m,n):
        #base case
        if (i==m-1 and j==n-1): return 1
        if (i>=m or j>=n): return 0
        
        #logic
        right=self.helper(i,j+1,m,n)
        bottom=self.helper(i+1,j,m,n)
        return right+bottom
    
'''
Approach - DP - bottom-up
Time complexity - O(M*N)
space complexity - O(M*N)
'''
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        #dp =[[ for _ in range(n+1)] for _ in range(m+1)]
        dp = [[0]*(n+1) for _ in range(m+1)]
        dp[m-1][n-1]=1
        
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if (i==m-1 and j==n-1): continue
                dp[i][j]=dp[i+1][j]+dp[i][j+1]
        return dp[0][0]
    
    
    
''''
Approach - DP - Tom bottom
'''
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        
        dp = [[1]*(n) for _ in range(m)]
        
        for i in range(1,m):
            for j in range(1,n):
                
                dp[i][j]=dp[i-1][j]+dp[i][j-1]
        return dp[m-1][n-1]
    
   