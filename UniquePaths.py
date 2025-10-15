# Time complexity: O(m*n) as we are using memoization technique
# Space: O(m*n) for memo matrix

# This is dynamic programming top down approach. Base case we check if the i and j index have reached the end then return 1. Other size move right and then move down and add the result

class Solution:
    def uniquePathsTopDown(self, m: int, n: int) -> int:
        memo = [[-1 for _ in range(n)] for _ in range(m)]
        def dfs(i, j):
            # Base Case
            if i == m or j == n:
                return 0
            if i == m - 1 and j == n - 1:
                return 1
            if memo[i][j] != -1:
                return memo[i][j]
            right = dfs(i, j + 1)
            left = dfs(i + 1, j)
            memo[i][j] = right + left

            return memo[i][j]

        return dfs(0, 0)

    # This approach is dynamic programming bottom up approach where we calculate the sum of paths from the bottom and sum the result upwards eventually getting the result in first row and col
    # Time is same(O(m*n) but space is efficient with O(n)
    def uniquePathsBottomUp(self, m: int, n: int) -> int:
        dp = [0] * n
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if i == m-1 or j == n -1:
                    dp[j] = 1
                else:
                    dp[j] = dp[j] + dp[j+1]

        return dp[0]