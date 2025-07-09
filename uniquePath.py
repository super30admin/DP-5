"""
From any cell (i,j), we can come either from top (i-1, j) or left (i, j-1)
So, dp[i][j] = dp[i-1][j] + dp[i][j-1]
Initialize first row and first column as 1 (only one way to reach those)
"""
"""
Time Complexity - O(m×n) 
Space Complexity - O(m×n)  — for DP 2D array 
"""


class uniquePath:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1] * n for _ in range(m)]

        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

        return dp[m - 1][n - 1]

if __name__ == "__main__":
    obj = uniquePath()
    print(obj.uniquePaths(3, 7))
