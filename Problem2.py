## Problem2: (https://leetcode.com/problems/unique-paths/)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        """
        Solution 1: Tabulation (Bottom-Up Dynamic Programming)
        
        LOGIC:
        1. We work backward from the target corner (m-1, n-1) to the start (0, 0).
        2. `dp[r][c]` stores the number of unique paths from cell (r, c) to the bottom-right corner.
        3. By allocating an extra row and column (size (m+1) x (n+1)) padded with zeros, out-of-bound
           accesses (`dp[r+1][c]` or `dp[r][c+1]`) safely evaluate to 0 without extra conditionals.
        4. Base Case: The destination `dp[m-1][n-1]` is set to 1 path.
        5. State Transition: For any cell, paths = paths moving right `dp[r][c+1]` + paths moving down `dp[r+1][c]`.

        TIME COMPLEXITY:
        - O(m * n): We iterate through every cell in the m x n grid exactly once.

        SPACE COMPLEXITY:
        - O(m * n): We allocate a 2D table of size (m + 1) * (n + 1) to store DP states.
        """
        # Create a 2D DP array padded with 1 extra row and 1 extra column initialized to 0
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        
        # Base Case: Starting at the bottom-right target cell itself counts as 1 valid path
        dp[m - 1][n - 1] = 1

        # Fill the table backwards starting from the destination (m-1, n-1) up to (0, 0)
        for r in range(m - 1, -1, -1):
            for c in range(n - 1, -1, -1):
                # Keep destination as 1; for all other cells, aggregate paths from right and down neighbors
                dp[r][c] = 1 if (r == m - 1 and c == n - 1) else dp[r][c + 1] + dp[r + 1][c]

        # The result at (0, 0) contains the total unique paths from top-left to bottom-right
        return dp[0][0]


"""
Solution 2: Memoization (Top-Down Dynamic Programming)

LOGIC:
1. Start at the top-left corner (0, 0) and recursively explore moving right (r, c+1) and down (r+1, c).
2. Base Cases:
   - Out of Bounds: Returning 0 when r == m or c == n (cannot move further).
   - Target Reached: Returning 1 when reaching (m-1, n-1).
3. Memoization: Cache subproblem results in `memo[r][c]` to avoid redundant calculations across overlapping paths.

TIME COMPLEXITY:
- O(m * n): Each state (r, c) is computed at most once and cached in `memo`.

SPACE COMPLEXITY:
- O(m * n): Requires O(m * n) space for the `memo` table plus O(m + n) for the recursive call stack depth.

# memo = [[-1] * n for _ in range(m)]

# def helper(r, c):
#     # Out of bounds check: if we step off the grid, no valid paths from here
#     if r == m or c == n:
#         return 0
#
#     # Cache hit: return already computed paths for this cell
#     if memo[r][c] != -1:
#         return memo[r][c]
#
#     # Base Case: Reached the target bottom-right cell
#     if r == m - 1 and c == n - 1:
#         memo[r][c] = 1
#         return 1
#
#     # Recursive step: Sum unique paths from moving right and moving down, then memoize
#     memo[r][c] = helper(r, c + 1) + helper(r + 1, c)
#     return memo[r][c]

# return helper(0, 0)
"""