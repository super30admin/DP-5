class Solution:
    def __init__(self):
        self.directions = [[0, 1], [1, 0]]

    def uniquePaths(self, m: int, n: int) -> int:
        return self.helper(m, n, 0, 0)

    def helper(self, m, n, i, j):
        # base
        if i < 0 or i == m or j < 0 or j == n:
            return 0
        if i == m - 1 and j == n - 1:
            return 1

        # logic
        return self.helper(m, n, i, j+1) + self.helper(m, n, i+1, j)
