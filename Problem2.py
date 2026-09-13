# Problem2: (https://leetcode.com/problems/unique-paths/)
# Time Complexity: O(m * n),We visit every cell in the grid exactly once with the nested loops.
# Space Complexity: O(m * n),We store a full 2D array of size m by n to hold the path counts.
# Approach:
# Use a 2D array dp where dp[i][j] holds the number of unique paths to reach cell (i, j).
# The robot can only move down or right, so it can only arrive at a cell from above or from the left.
# Cells in the top row or left column have exactly one path, since there is only one way to reach them.
# Every other cell's path count is the sum of the cell above it and the cell to its left.

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for _ in range(n)] for _ in range(m)]  # create m x n grid filled with zeros

        for i in range(m):  # loop over each row
            for j in range(n):  # loop over each column
                if i == 0 or j == 0:  # top row or left column, only one path along the edge
                    dp[i][j] = 1
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]  # sum of paths from above and from the left

        return dp[m - 1][n - 1]  # bottom right corner holds the final answer