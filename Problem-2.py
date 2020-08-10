# Time Complexity :O(M*N)
# Space Complexity :O(M*N) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    mem = {}
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        # create DP array as big as matrix of all ones
        dp = [[1]*(n) for i in range( m)]
        # loop through array from second row and col to end
        for i in range(1,m):
            for j in range(1,n):
                # calculate how manyways you can reach this point
                dp[i][j] = dp[i-1][j]+ dp[i][j-1]
        # return how many ways you can reach end place
        return dp[-1][-1]