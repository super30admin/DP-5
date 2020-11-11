"""
Leetcode: https://leetcode.com/problems/unique-paths/

Approach: Dynamic Programming
    1. Initiate 2D array d[m][n] = number of paths. To start, put number of paths equal to 1 for
        the first row and the first column.
        For the simplicity, one could initiate the whole 2D array by ones.
    2. Iterate over all "inner" cells: d[col][row] = d[col - 1][row] + d[col][row - 1].
    3. Return d[m - 1][n - 1].
Time complexity: O(N×M).
Space complexity: O(N×M).
"""

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        d = [[1] * n for _ in range(m)]

        for col in range(1, m):
            for row in range(1, n):
                d[col][row] = d[col - 1][row] + d[col][row - 1]

        return d[m - 1][n - 1]