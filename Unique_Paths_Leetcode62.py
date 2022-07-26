class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # DP TC -O(n*m) SC - O(n*m)
        dp = [[1] * m for _ in range(n)]

        for i in range(1, n):
            for j in range(1, m):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        return dp[n - 1][m - 1]

    '''
        # DP TC - O(n*m) SC - O(n)
        dp = [1]*(m+1)
        dp[m] = 0
        for i in range(n-2,-1,-1):
            for j in range(m-1,-1,-1):
                dp[j] = dp[j+1] + dp[j]
        return dp[0]
    '''

    '''
    # Recursion Time Limit Exceeded TC - O(n**n) exponential
        return self.helper(0,0,m,n)

    def helper(self, i, j, m , n):
        # base
        if i == m or j == n:
            return 0

        if i == m-1 and j == n-1:
            return 1

        # logic
        return self.helper(i,j+1,m,n) + self.helper(i+1,j,m,n)
        '''