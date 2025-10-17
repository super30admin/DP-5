"""
TC: O(M*N) The time complexity is dominated by the nested loops that iterate through every cell of the M x N grid exactly once to compute the DP values.
SC: O(M*N) The space complexity is linear with respect to the size of the grid, required to store the two-dimensional DP array.

Approach:

This problem is solved using Dynamic Programming (DP). The goal is to find the number of unique paths from the top-left corner (0, 0) to the bottom-right corner (M-1, N-1) of an M x N grid, moving only down or right.

The core idea is that the number of unique paths to reach a cell (i, j) is the sum of the unique paths to reach the cell immediately below it, (i+1, j), and the cell immediately to the right of it, (i, j+1).

1. DP Array Definition: We use a 2D array, dp[i][j], to store the number of unique paths from cell (i, j) to the bottom-right corner.
2. Initialization (Base Cases): The boundary cells are the base cases. Any cell in the last row or last column has only 1 path to the end.
3. DP Transition: We iterate through the grid from the bottom-right to the top-left. For any internal cell (i, j), the number of paths is calculated by the recurrence relation: $\text{dp}[i][j] = \text{dp}[i+1][j] + \text{dp}[i][j+1]$.
4. Result: The final answer is the value stored in the starting cell, $\text{dp}[0][0]$, which represents the total number of unique paths from the start to the end.

The problem ran successfully on LeetCode.
"""
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        def inBounds(r, c):
            return r<n and c<m
        
        dp = []

        for i in range(m-1):
            dp.append([-1]*(n-1) + [1])
                
        dp.append([1]*n)

        for i in range(m-2, -1, -1):
            for j in range(n-2, -1, -1):
                if i == m-1 and j == n-1:
                    continue
                dp[i][j] = dp[i+1][j] + dp[i][j+1]
        
        return dp[0][0]


    