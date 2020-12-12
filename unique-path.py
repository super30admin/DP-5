class Solution(object):
    # def helper(self,m,n,i,j):
    #         if i==m-1 and j==n-1:
    #             return 1
    #         if i>=m or j>=n:
    #             return 0
    #         return self.helper(m,n,i+1,j)+self.helper(m,n,i,j+1)
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        dp = [[0 for i in range(n + 1)] for j in range(m + 1)]

        dp[m - 1][n - 1] = 1
        # print(dp)
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if dp[i][j] != 1:
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1]
        return dp[0][0]

        # brute force-time- 2**mn  space-O(m*n)
        # dp - time,space-O(m*n)