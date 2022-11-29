#62. Unique Paths
"""
Time Complexity: O(mn)
Space Complexity: O(mn)
"""

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if n>m:
            return self.uniquePaths(n,m) 
        dp = [0 for _ in range(n)]
        dp[0] = 1

        for i in range(1,m+1):
            for j in range(1,n):
                dp[j] = dp[j] + dp[j-1]
                dp[j] = dp[j]
        # print(dp,curr)
        return dp[n-1]
