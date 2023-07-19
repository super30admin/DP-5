# Time Complexity : O(mn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [0 for _ in range(n)]
        for c in range(n):
            dp[c] = 1
        for r in range(1, m):
            for c in range(1, n):
                dp[c] = dp[c-1] + dp[c]
        return dp[n-1]