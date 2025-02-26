class Solution:
    # dp
    # TC: O(m*n)
    # SC:O(n)
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n ==0:
            return 0
        dp = [1]*(n)
        for i in range(1,m):
            for j in range(1,n):
                dp[j] = dp[j-1]+dp[j]
        return dp[n-1]
