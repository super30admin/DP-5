# Brut force
# Time O(2*(m+n))
# Space O(m+n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.dfs(0, 0, m, n)

    def dfs(self, i: int, j: int, m: int, n: int) -> int:
        # base
        if i == m-1 and j == n-1: return 1
        if i >= m or j >= n: return 0

        right = self.dfs(i, j+1, m, n)
        bottom = self.dfs(i+1, j, m, n)

        return right + bottom

# Memoization
# Time O(2*(m+n))
# Space O(m*n)
class Solution:
    def __init__(self):
        self.memo = None

    def uniquePaths(self, m: int, n: int) -> int:
        self.memo = [ [0] * n for i in range(m)]
        return self.dfs(0, 0, m, n)

    def dfs(self, i: int, j: int, m: int, n: int) -> int:
        # base
        if i == m-1 and j == n-1: return 1
        if i >= m or j >= n: return 0
        if self.memo[i][j] != 0: return self.memo[i][j]
        
        self.memo[i][j] = self.dfs(i, j+1, m, n) + self.dfs(i+1, j, m, n)

        return self.memo[i][j]

# DP
# Time O(n*m)
# Space O(n*m)    
class Solution:
    
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0] * (n+1) for i in range(m+1)]
        dp[m-1][n-1] = 1
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                if dp[i][j] == 0:
                    dp[i][j] = dp[i+1][j] + dp[i][j+1]
        return dp[0][0]