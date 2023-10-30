# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        dp = [[0 for x in range(n)] for x in range(m)]

        for j in range(n):
            dp[m-1][j] = 1

        for i in range(m):
            dp[i][n-1] = 1

        for i in range(m-2, -1, -1): 
            for j in range(n-2, -1, -1): 
                dp[i][j] = dp[i+1][j] + dp[i][j+1]

        return dp[0][0]
