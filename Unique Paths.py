import numpy as np
class Solution:
    # TC = O(m*n)
    # SC = O(m*n)
    def uniquePaths(self, m: int, n: int) -> int:
        grid = np.ones((m, n))
        
        for i in range(1, m):
            for j in range(1, n):
                grid[i][j] = grid[i-1][j] + grid[i][j-1]

        return int(grid[m-1][n-1])

    # TC = O(m*n)
    # SC = O(n)
    def uniquePaths(self, m: int, n: int) -> int:
        row = np.ones(n)
        
        for i in range(1, m):
            for j in range(1, n):
                row[j] = row[j] + row[j-1]

        return int(row[n-1])
