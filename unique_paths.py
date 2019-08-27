"""
Time: O(n*m)
Space: O(n*m)
Leet: Accepted
Problems: None
"""



import numpy as np
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        if m==1 and n==1: #edge case
            return 1
        dp = np.zeros((n,m), dtype=int) #matrix of zeros
        dp[0][0] = 0
        if n>1: #edge case
            dp[1][0] = 1 #only 1 possible path to get to this position
        if m>1: #edge case
            dp[0][1] = 1 #only 1 possible path to get to this position


        for row in range(n):
            for col in range(m):
                if row-1>=0:
                    dp[row][col] += dp[row-1][col] #add number of paths to get to above position
                if col-1>=0:
                    dp[row][col] += dp[row][col-1] #add number of paths to get to left position
        return dp[n-1][m-1]
