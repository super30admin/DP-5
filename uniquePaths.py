"""
TC: O(M*N)
"""
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        """
        dp = [[0 for i in range(n)] for _ in range(m)]
        
        for row in range(m):
            for col in range(n):
                if row == 0 or col == 0:
                    dp[row][col] = 1
                else:
                    dp[row][col] = dp[row-1][col] + dp[row][col-1] 
        
        return dp[-1][-1]
        """
        dp = [1 for _ in range(n)]
        for row in range(1,m):
            for col in range(1,n):
                dp[col] += dp[col-1]
        return dp[-1]
        
