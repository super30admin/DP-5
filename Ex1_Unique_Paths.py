# ----------------------------------------------------
# Intuition:
#
# You're at the top-left corner of an `m x n` grid,
# and you can move **only right or down** to reach the bottom-right corner.
#
# Let's say you're at cell (i, j):
# There are only two ways to reach here:
#    - From the cell above → (i-1, j)
#    - From the cell to the left → (i, j-1)
#
# So, the number of unique paths to (i, j) is:
#     dp[i][j] = dp[i-1][j] + dp[i][j-1]
#
# Now we build the solution using one of the following:
#
# 1. ✅ Most Optimal (1D Bottom-Up DP):
#    - Instead of a 2D grid, we use a 1D array `dp[j]` where:
#         dp[j] represents number of paths to current cell in current row.
#    - Since each row only depends on the previous row, we can update in-place.
#    → Time: O(m × n), Space: O(n)
#
# 2. 💬 Bottom-Up (2D DP):
#    - Use a full 2D grid dp[m][n]
#    - Initialize first row and first column as 1 (only one way to go right/down)
#    - Fill rest using transition: dp[i][j] = dp[i-1][j] + dp[i][j-1]
#    → Time: O(m × n), Space: O(m × n)
#
# 3. 💬 Top-Down Memoization (Recursive DP):
#    - Use recursion with a 2D memo table to avoid recomputation.
#    - Base case: If you're in first row or column → 1 path.
#    - Recursively compute paths to reach (i, j)
#    → Time: O(m × n), Space: O(m × n) for memo + stack
#
# 4. 💬 Naive Recursive (Brute Force):
#    - Recursively go right and down from (0, 0) to (m-1, n-1)
#    - No caching, so time blows up quickly.
#    → Time: O(2^(m+n)), Space: O(m + n) recursion stack
# ----------------------------------------------------

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # ----------------------------------------------------
        # 1. Most Optimal: Bottom-Up 1D DP (Space Optimized)
        # ----------------------------------------------------
        dp = [1] * n  # Only one way to reach cells in first row

        # Start filling from second row
        for _ in range(1, m):
            for j in range(1, n):
                # Update paths to current cell:
                # dp[j] (top) + dp[j-1] (left)
                dp[j] = dp[j] + dp[j - 1]

        return dp[-1]  # Last cell has the result

        # ----------------------------------------------------
        # 💬 2. Bottom-Up 2D DP
        # ----------------------------------------------------
        # dp = [[0] * n for _ in range(m)]
        # for i in range(m):
        #     dp[i][0] = 1  # First column: only one path (down)
        # for j in range(n):
        #     dp[0][j] = 1  # First row: only one path (right)
        # for i in range(1, m):
        #     for j in range(1, n):
        #         dp[i][j] = dp[i-1][j] + dp[i][j-1]
        # return dp[m-1][n-1]

        # ----------------------------------------------------
        # 💬 3. Memoization (Top Down DP)
        # ----------------------------------------------------
        # memo = [[-1] * (n + 1) for _ in range(m + 1)]
        # def dp(i, j):
        #     if i == 1 or j == 1:
        #         return 1  # Base case: first row or column
        #     if memo[i][j] != -1:
        #         return memo[i][j]
        #     memo[i][j] = dp(i - 1, j) + dp(i, j - 1)
        #     return memo[i][j]
        # return dp(m, n)

        # ----------------------------------------------------
        # 💬 4. Brute Force Recursion (Naive)
        # ----------------------------------------------------
        # if m == 1 or n == 1:
        #     return 1
        # return self.uniquePaths(m - 1, n) + self.uniquePaths(m, n - 1)


if __name__ == "__main__":
    solution = Solution()

    # Test case 1
    m1, n1 = 3, 7
    print(f"Unique paths in {m1}x{n1} grid: {solution.uniquePaths(m1, n1)}")  # Expected: 28

    # Test case 2
    m2, n2 = 3, 2
    print(f"Unique paths in {m2}x{n2} grid: {solution.uniquePaths(m2, n2)}")  # Expected: 3

    # Test case 3
    m3, n3 = 1, 1
    print(f"Unique paths in {m3}x{n3} grid: {solution.uniquePaths(m3, n3)}")  # Expected: 1

    # Test case 4
    m4, n4 = 10, 10
    print(f"Unique paths in {m4}x{n4} grid: {solution.uniquePaths(m4, n4)}")  # Expected: 48620

    