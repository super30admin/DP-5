'''
Time Complexity: O(m*n)
Space Complexity: O(n)
Run on Leetcode: YES
'''
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [1] * (n + 1)
        dp[n] = 0
        for _ in range(m - 1):
            for idx in range(n - 1, -1, -1):
                dp[idx] += dp[idx + 1]
        return dp[0]