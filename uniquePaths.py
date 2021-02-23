# TC: O(mn)
# SC: O(n)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [1] * (n+1)
        dp[-1] = 0
        for i in range(m-1):
            for j in range((n-1), -1, -1):
                dp[j] += dp[j+1]
        
        return dp[0]