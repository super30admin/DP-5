class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n == 0:
            return 0
        return self.dfs(m, n, 0, 0)

    def dfs(self, m, n, i, j):
        # base
        if i == m or j == n:
            return 0
        if i == m - 1 and j == n - 1:
            return 1

        return self.dfs(m, n, i + 1, j) + self.dfs(m, n, i, j + 1)  # recurse

# Brute Force
# Time Complexity: O(2^mn)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : No, gave Time limit exceed
# Any problem you faced while coding this : No
