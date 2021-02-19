# Dfs
# TC & SC: Exponential
# At each cell we can choose to go down/right- we send each decision as a recursion call with further recursion calls when it splits. Each Recursive flow is a success if it is able to reach last cell. We count number of recursive calls that make to the end 
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.helper(m,n,0,0)
    
    def helper(self, m, n, i, j):
        # base
        if i == m or j == n: return 0
        if i == m-1 and j == n-1: return 1        
        # logic
        return self.helper(m,n, i, j+1) + self.helper(m,n, i+1, j)

# DP
# TC : O(mn)
# SC : O(mn)
# Subproblem: Store at each cell- number of paths from start to that cell.
# dp[i][j] = dp[i][j+1] + dp[i+1][j]
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for i in range(n+1)] for i in range(m+1)]
        dp[m-1][n-1] = 1
        for i in range(m-1, -1,-1):
            for j in range(n-1,-1,-1):
                if i == m-1 and j == n-1: continue
                dp[i][j] = dp[i][j+1] + dp[i+1][j]
        return dp[0][0]

# DP space optimized
# TC: O(mn)
# SC: O(n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [1 for i in range(n)]
        for i in range(m-2, -1,-1):
            right = 0
            for j in range(n-1,-1,-1):
                dp[j] = dp[j] + right
                right = dp[j]
        return dp[0]

