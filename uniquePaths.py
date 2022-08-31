#Time Complexity: O(NM)
#Space Complexity: O(MN)

def uniquePaths(self, m: int, n: int) -> int:
    if not m and not n:
        return 0

    dp = [[1] * n for i in range(m)]
    # print(dp)

    for i in range(1, m):
        for j in range(1, n):
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

    return dp[-1][-1]