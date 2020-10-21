# Time - O(m*n)
# Space - O(m*n)
# using dp tabular method and getting max possible number of paths

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        dp = [[1 for i in range(n)] for j in range(m)]
        
        
        for i in range(1,m):
            for j in range(1,n):
                dp[i][j] = dp[i][j-1] + dp[i-1][j]
        
        return dp[-1][-1]
