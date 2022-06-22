# Time Complexity : O(M*N) where M and N are the dimension of the grid
# Space Complexity : O(N) number of columns in the grid
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [0 for _ in range(n+1)]
        dp[n - 1] = 1
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                if i == m - 1 and j == n - 1: continue
                dp[j] = dp[j+1] + dp[j]
                
            
        return dp[0]