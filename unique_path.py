class Solution:
    def __init__(self):
        self.count = 0  # to check all paths

    def uniquePaths(self, m: int, n: int) -> int:
        # exhaustive approach,use recrusion, 2 choices at each cell either down or right, return sum of all the possible paths to the parent cell in the exhaustive tree
        # time complexity is 2^(m+n)
        # space complexity is 2^(m+n)

        self.helper(m, n, 0, 0)
        return self.count

    def helper(self, m, n, i, j):
        # base case
        if i == m - 1 and j == n - 1:
            self.count += 1
            return
        if i >= m or j >= n:
            return

        # logic
        self.helper(m, n, i, j + 1)  # move right
        self.helper(m, n, i + 1, j)  # move down

    # memoization using top down dp approach
    def __init__(self):
        self.memo = None

    def uniquePaths(self, m: int, n: int) -> int:
        self.memo = [[0 for _ in range(n)] for _ in range(m)]

        return self.helper(m, n, 0, 0)

    def helper(self, m, n, i, j):
        # base case
        if i == m - 1 and j == n - 1:
            return 1
        if i >= m or j >= n:
            return 0
        if self.memo[i][j] != 0:
            return self.memo[i][j]

        # logic
        case0 = self.helper(m, n, i, j + 1)  # move right
        case1 = self.helper(m, n, i + 1, j)  # move down
        self.memo[i][j] = case0 + case1
        return case0 + case1

    # time complexity is O(m*n)
    # space complexity is O(2(m+n))

    # bottom up tabulation dp method
    def __init__(self):
        self.memo = None

    def uniquePaths(self, m: int, n: int) -> int:
        self.memo = [[0 for _ in range(n)] for _ in range(m)]

        return self.helper(m, n, 0, 0)

    def helper(self, m, n, i, j):
        # base case
        if i == m - 1 and j == n - 1:
            return 1
        if i >= m or j >= n:
            return 0
        if self.memo[i][j] != 0:
            return self.memo[i][j]

        # logic
        case0 = self.helper(m, n, i, j + 1)  # move right
        case1 = self.helper(m, n, i + 1, j)  # move down
        self.memo[i][j] = case0 + case1
        return case0 + case1

    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for _ in range(n)] for _ in range(m)]

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if i == m - 1 or j == n - 1:
                    dp[i][j] = 1
                else:
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1]
        return dp[0][0]


# Time Complexity: O(m*n)
# Space Complexity: O(n)
