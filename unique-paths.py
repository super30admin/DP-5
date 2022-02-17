class Solution(object):
    counter = 0
    def uniquePaths(self, m, n, memo={}):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        #DP Optimized
        dp = [0 for i in range(n+1)]
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                if i == m-1:
                    dp[j] = 1
                else:
                    dp[j] = dp[j+1] + dp[j]
        return  dp[0]
        
        
        #DP Bottom Up
        # dp = [[0 for i in range(n+1)] for j in range(m+1)]
        # for i in range(m-1, -1, -1):
        #     for j in range(n-1, -1, -1):
        #         if i == m-1 and j == n-1:
        #             dp[i][j] = 1
        #         else:
        #             dp[i][j] = dp[i][j+1] + dp[i+1][j]
        # return  dp[0][0]
        
        # key = str(m) + ',' + str(n)
        # if key in memo:
        #     return memo[key]
        # if m == 1 or n == 1:
        #     return 1
        # memo[key] = self.uniquePaths(m - 1, n, memo) + self.uniquePaths(m, n - 1, memo)
        # return memo[key]