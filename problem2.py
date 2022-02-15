# Approach 1: Recursive
# Time Complexity : exponential
# Space Complexity: O(1)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n == 0:
            return 0

        return self.dfs(m, n, 0, 0)

    def dfs(self, m, n, i, j):
        if i == m - 1 and j == n - 1:
            return 1

        if i == m or j == n:
            return 0

        return self.dfs(m, n, i, j + 1) + self.dfs(m, n, i + 1, j)

# Approach 2: Recursive with memoization
# Time Complexity : O(m*n)
# Space Complexity: O(m*n)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        self.dp = [[None] * n for i in range(m)]
        if m == 0 or n == 0:
            return 0

        return self.dfs(m, n, 0, 0)

    def dfs(self, m, n, i, j):
        if i == m - 1 and j == n - 1:
            return 1

        if i == m or j == n:
            return 0

        if self.dp[i][j] is not None:
            return self.dp[i][j]

        self.dp[i][j] = self.dfs(m, n, i, j + 1) + self.dfs(m, n, i + 1, j)
        return self.dp[i][j]

Approach 3: Iterative (DP)
# Time Complexity : O(m*n)
# Space Complexity: O(m*n)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n == 0:
            return 0
        dp = [[0] * (n+1) for i in range(m+1)]

        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if i == m-1 and j == n-1:
                    dp[i][j]=1
                else:
                    dp[i][j] = dp[i+1][j] + dp[i][j+1]


        return dp[0][0]

Approach 4: Dp with one dimenstional array
# Time Complexity : O(m*n)
# Space Complexity: O(n)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n == 0:
            return 0
        dp = [1] * n

        for i in range(m-2,-1,-1):
            for j in range(n-2,-1,-1):
                dp[j] = dp[j] + dp[j+1]


        return dp[0]
