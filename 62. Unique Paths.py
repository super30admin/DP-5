# T = O(n^2)
# S = O(n^2)

# Approach:
# Build DP array and build it through the top and return the top element.
# (Here its build top down instead of bottom up)


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1 for i in range(n)] for j in range(m)]
        
        for i in range(1,m):
            for j in range(1,n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[-1][-1]