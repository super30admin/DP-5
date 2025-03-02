# Start from bottom up and keep calculating the number of paths by checking right and down
# TC: O(m * n)
# SC: O(m * n)
# Yes, this worked in leetcode

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 and n == 0:
            return 0

        dp = [[0] * (n + 1) for _ in range(m + 1)]
        print(dp)
        dp[m - 1][n - 1] = 1
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if i != m - 1 and j != n - 1:
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1]
                else:
                    dp[i][j] = 1

        return dp[0][0]
    
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 and n == 0:
            return 0

        dp = [1] * n
        for i in range(m - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                dp[j] = dp[j + 1] + dp[j]

        return dp[0]