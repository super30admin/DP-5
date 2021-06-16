# using recursion
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.helper(m, n, 0, 0)

    def helper(self, row: int, column: int, rowindex: int, columnindex: int) -> int:
        if rowindex == row or columnindex == column:
            return 0
        if rowindex == row - 1 and columnindex == column - 1:
            return 1
        return self.helper(row, column, rowindex, columnindex + 1) + self.helper(row, column, rowindex + 1, columnindex)

    class Solution:
        def uniquePaths(self, m: int, n: int) -> int:

            dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
            dp[m - 1][n - 1] = 1
            for rowindex in range(m - 1, -1, -1):
                for columnindex in range(n - 1, -1, -1):
                    if rowindex == m - 1 and columnindex == n - 1: continue
                    dp[rowindex][columnindex] = dp[rowindex + 1][columnindex] + dp[rowindex][columnindex + 1]
            return dp[0][0]
