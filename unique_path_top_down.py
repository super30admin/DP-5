"""
Time Complexity : O(m*n) where m is the number of rows and n is the number of columns
Space Complexity : O(m*n) where m is the number of rows and n is the number of columns

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""


class Solution:
    def __init__(self):
        self.memo = None

    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n == 0:
            return 0
        self.memo = [[0 for _ in range(n)] for _ in range(m)]
        return self.helper(m, n, 0, 0)

    def helper(self, m, n, i, j):
        # base
        if i < 0 or i == m or j < 0 or j == n:
            return 0
        if i == m - 1 and j == n - 1:
            return 1

        # logic
        if self.memo[i][j] == 0:
            self.memo[i][j] = self.helper(
                m, n, i, j+1) + self.helper(m, n, i+1, j)
        return self.memo[i][j]
