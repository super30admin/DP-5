#Time complexity: O(m*n)
#Space complexity: O(n)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [1 for _ in range(n)]
        
        for i in range(1, m):
            for j in range(1, n):
                dp[j] = dp[j] + dp[j-1]
        return dp[n-1]
#Time complexity: O(m*n)
#Space complexity: O(m*n)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1 for _ in range(n)] for _ in range(m)]
        
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[m-1][n-1]
        
