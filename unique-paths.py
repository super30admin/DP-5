# The uniquePaths method calculates the number of unique paths in an m x n grid from the top-left to the bottom-right corner.

# Use DFS with memoization:
# - `dfs(i, j)` computes the number of paths from cell (i, j) to the destination.
# - Base cases:
#   - If at the destination, return 1.
#   - If out of bounds, return 0.
# - Use memoization to store results for previously computed cells.

# Return the number of unique paths starting from the top-left corner.

# TC: O(m * n) - Each cell is visited at most once.
# SC: O(m * n) - Space for the memoization table and recursion stack.


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        memo = [[-1] * n for _ in range(m)]
        def dfs(i, j):
            if i == (m - 1) and j == (n - 1):
                return 1
            if i >= m or j >= n:
                return 0
            if memo[i][j] != -1:
                return memo[i][j]
            
            memo[i][j] =  dfs(i, j + 1) + dfs(i + 1, j)
            return memo[i][j]
        
        return dfs(0, 0)