"""
move towards right and bottom , add the total paths at each step
TC: O(m*n)
Sp: O(n)
"""
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [0]*(n)
        dp[0] = 1
        for i in range(m):
            for j in range(1, n):
                dp[j] = dp[j] + dp[j-1]
        return dp[-1]