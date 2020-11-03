# Time Complexity : O(n*m)
# Space Complexity : O(n*m)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        dp = [[0 for _ in range(m)] for _ in range(n)]
        
        for i in range(0,m):
            dp[0][i] = 1
        
        for i in range(0,n):
            dp[i][0] = 1
        
        
        for i in range(1,n):
            for j in range(1,m):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        
        return dp[n-1][m-1]
