"""
Time Complexity : uniquePaths_dfs - O(2^mn)
                  uniquePaths_dp - O(mn)
Space Complexity : uniquePaths_dfs - O(1) [O(2^mn) - stack space]
                   uniquePaths_dp - O(mn)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def uniquePaths_dfs(self, m, n):
        return self.helper(0, 0, m, n)
        
    def helper(self, i, j, m, n):
        # base case
        if i >= m or j >= n:
            return 0
        if i == m-1 and j == n-1:
            return 1
        
        # logic
        right = self.helper(i, j+1, m, n)
        down = self.helper(i+1, j, m, n)
        
        return right + down
    
    def uniquePaths_dp(self, m, n):
        dp = [[0]*(n+1) for i in range(m+1)]
        dp[m-1][n-1] = 1
        
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                if i == m-1 and j == n-1: continue
                dp[i][j] = dp[i+1][j] + dp[i][j+1]
        
        return dp[0][0]
    
s = Solution()
print(s.uniquePaths_dp(7, 3))