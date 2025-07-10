# TC: O(m*n)
# SC: O(n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[1]*n
        for row in range(m-2, -1, -1):
            for col in range(n-2,-1,-1):
                dp[col]=dp[col]+dp[col+1]
        
        return dp[0]