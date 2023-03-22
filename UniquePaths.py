"""
Rasika Sasturkar
Time complexity: Brute force - O(2^(m*n)), DP - O(m*n)
Space complexity: O(m*n)
"""


def uniquePaths(m: int, n: int) -> int:
    # null case
    if m == 0 or n == 0:
        return 0

    # brute force
    # def dfs(i, j, m, n):
    #     # base case
    #     if i == m - 1 and j == n - 1:
    #         return 1
    #     if i < 0 or j < 0 or i == m or j == n:
    #         return 0
    #     # logic
    #     return dfs(i, j + 1, m, n) + dfs(i + 1, j, m, n)
    #
    # return dfs(0, 0, m, n)

    # Top-down DP
    # memo = [[0 for _ in range(n)] for _ in range(m)]
    #
    # def dfs_memo(i, j, m, n):
    #     # base case
    #     if i == m - 1 and j == n - 1:
    #         return 1
    #     if i < 0 or j < 0 or i == m or j == n:
    #         return 0
    #     # logic
    #     if memo[i][j] == 0:
    #         memo[i][j] = dfs_memo(i, j + 1, m, n) + dfs_memo(i + 1, j, m, n)
    #     return memo[i][j]
    #
    # return dfs_memo(0, 0, m, n)

    # Bottom-up DP
    dp = [[0] * (n + 1)] * (m + 1)
    dp[m - 1][n - 1] = 1
    for i in range(m - 1, -1, -1):
        for j in range(n - 1, -1, -1):
            if i == m - 1 and j == n - 1:
                continue
            dp[i][j] = dp[i + 1][j] + dp[i][j + 1]
    return dp[0][0]


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(uniquePaths(m=3, n=7))  # prints 28
    print(uniquePaths(m=3, n=2))  # prints 3


if __name__ == "__main__":
    main()
