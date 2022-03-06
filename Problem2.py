# // Time Complexity : O(nm) where nm is the size of the grid. 
# // Space Complexity : O(nm) where nm is the size of the grid. 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if i == m-1 and j == n-1:
                    dp[i][j] = 1
                    continue
                dp[i][j] = dp[i+1][j] + dp[i][j+1] 
        return dp[0][0]
