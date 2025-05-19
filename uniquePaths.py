class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        """
        Approach:
        1. Use dynamic programming with space optimization.
        2. Start from the bottom row (last row), where all values are 1 (only one way to go right).
        3. For each upper row, calculate the number of paths from right to left using:
           newRow[j] = newRow[j+1] + row[j]
           - newRow[j+1] → right cell
           - row[j] → cell below
        4. After processing all rows, the top-left cell will have the total number of unique paths.

        Time Complexity: O(m * n) — Every cell is visited once.
        Space Complexity: O(n) — Only two 1D arrays (or one rolling array) are used.
        """
        row = [1] * n

        for i in range(m - 1):
            newRow = [1] * n
            for j in range(n - 2, -1, -1):
                newRow[j] = newRow[j + 1] + row[j]
            row = newRow

        return row[0]
