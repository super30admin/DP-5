class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        #dp : less space
        #time complexity: O(m*n)
        #space complexity: O(min(m,n))
        if m is 0 and n is 0:
            return 0
        if n>m:
            return self.uniquePaths(n,m)
        dp = [1 for x in xrange(m)]
        for i in xrange(m-2,-1,-1):
            right = 0
            for j in xrange(n-1,-1,-1):
                dp[j] += right
                right = dp[j]
        return dp[0]
        # #dp 
        # #time and space complexity: O(m*n)
        # if m is 0 and n is 0:
        #     return 0
        # dp = [[0 for x in xrange(n+1)] for x in xrange(m+1)]
        # #last element set to 1 as that is the dest, this stimulates, last row and last col as 1
        # #dummy row as 0 so no additional ops' necessary
        # dp[m-1][n-1] = 1
        # for i in xrange(m-1,-1,-1):
        #     for j in xrange(n-1,-1,-1):
        #         if i == m-1 and j == n-1:
        #             continue
        #         dp[i][j] = dp[i+1][j] + dp[i][j+1]
        # return dp[0][0]
        #brute force
        #time complexity: 2^m*n
        # if m is 0 and n is 0:
        #     return 0
        # def helper(i,j,m,n):
        #     #base
        #     if i == m or j == n:
        #         return 0
        #     if i == m-1 or j == n-1:
        #         return 1
        #     #logic
        #     return helper(i+1,j,m,n) + helper(i,j+1,m,n)
        # return helper(0,0,m,n)
