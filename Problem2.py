#Time complexity: O(m*n) where m and n are rows and columns respectively
#Space complexity: O(m*n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1]*m]*n
        for rows in range(1,n):
            for cols in range(1,m):
                dp[rows][cols] = dp[rows-1][cols] + dp[rows][cols-1]
        return dp[-1][-1]
