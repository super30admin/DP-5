# Time Complexity : O(mn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        uniquePaths = [[0]*n]*m
        for i in range(m):
            uniquePaths[i][0] = 1
            
        for i in range(n):
            uniquePaths[0][i] = 1
            
        for i in range(1,m):
            for j in range(1,n):
                uniquePaths[i][j] = uniquePaths[i-1][j] + uniquePaths[i][j-1]
                
        return uniquePaths[m-1][n-1]