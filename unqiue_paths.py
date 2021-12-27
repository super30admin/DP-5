# Did this code successfully run on Leetcode : YES

# approach
# DP
# left most col will be all 1's since there is only a single path from (0, 0) to any index i in (0, i)
# similarly top most row will be all 1's since there is only a single path from (0, 0) to any index i in (i, 0)
# other than these indices, dp[i][j] = dp[i][j-1] + dp[i-1][j]
# TC: O(M*N)
# SC: O(M*N)


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for _ in range(n)] for _ in range(m)]
        for i in range(m):
            dp[i][0] = 1
        for i in range(n):
            dp[0][i] = 1
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[-1][-1]