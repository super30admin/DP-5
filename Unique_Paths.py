"""
Approach (2D DP):
- Create a 2D DP table `dp[m][n]` where dp[i][j] = number of unique paths to reach (i,j).
- Base case: dp[0][0] = 1 (start point).
- For each cell, the number of paths = from top (i-1, j) + from left (i, j-1), if within bounds.

Time Complexity: O(m * n)
Space Complexity: O(m * n)
"""
"""
Approach (1D DP optimization):
- Instead of a full 2D matrix, use a 1D array to store only current row's values.
- We start from the bottom-right and move to the top-left.
- dp[j] = dp[j] + dp[j+1], moving right to left.

Time Complexity: O(m * n)
Space Complexity: O(n)
"""
class Solution(object):
    def uniquePaths_2D(self, m, n):
        dp = [[0]*n for _ in range(m)]
        dp[0][0] = 1
        for i in range(m):
            for j in range(n):
                if i == j == 0:
                    continue
                val = 0
                if i > 0:
                    val += dp[i-1][j]
                if j > 0:
                    val += dp[i][j-1]
                dp[i][j] = val
        return dp[m-1][n-1]
    
    def uniquePaths_1D(self, m: int, n: int) -> int:
        dp = [1] * n
        for i in range(m-2, -1, -1):
            for j in range(n-2, -1, -1):
                dp[j] += dp[j+1]
        return dp[0]

def main():
    sol = Solution()
    test_cases = [
        (3, 7, 28),  # 3 rows, 7 columns
        (3, 2, 3),   # 3 rows, 2 columns
        (1, 1, 1),   # 1 cell
        (1, 10, 1),  # 1 row
        (10, 1, 1),  # 1 column
    ]

    print("Testing uniquePaths_2D:")
    for m, n, expected in test_cases:
        result = sol.uniquePaths_2D(m, n)
        print(f"m={m}, n={n} => Output: {result} | Expected: {expected} | {'PASS' if result == expected else 'FAIL'}")

    print("\nTesting uniquePaths_1D:")
    for m, n, expected in test_cases:
        result = sol.uniquePaths_1D(m, n)
        print(f"m={m}, n={n} => Output: {result} | Expected: {expected} | {'PASS' if result == expected else 'FAIL'}")


if __name__ == "__main__":
    main()