class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        #O(mn) both
        dp = [[0 for x in range(n)] for y in range(m)]
        #reach down 1 way always
        for i in range(m):
            dp[i][0]=1
        #reach right 1 way always
        for j in range(n):
            dp[0][j]=1
        
        #reach any cell>either from above or from left
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        
        return dp[-1][-1]