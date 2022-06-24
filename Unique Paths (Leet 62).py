'''
Using Bottom Up DP
Time: O(mn)
Space: O(n)
'''

class Solution:

    def uniquePaths(self, m: int, n: int) -> int:
        self.dp = [0 for x in range(n + 1)]

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if i == m - 1 and j == n - 1:
                    self.dp[j] = 1
                else:
                    self.dp[j] = self.dp[j] + self.dp[j + 1]

        return self.dp[0]


'''
Using Bottom Up DP
Time: O(mn)
Space:O(mn)

'''

class Solution:

    def uniquePaths(self, m: int, n: int) -> int:
        self.dp = [[0 for x in range(n + 1)] for y in range(m + 1)]

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if i == m - 1 and j == n - 1:
                    self.dp[i][j] = 1
                else:
                    self.dp[i][j] = self.dp[i][j + 1] + self.dp[i + 1][j]

        return self.dp[0][0]


'''
Using Top Down DP
Time: O(mn)
Space: O(mn
'''

class Solution:

    def uniquePaths(self, m: int, n: int) -> int:
        self.dp = [[0 for x in range(n + 1)] for y in range(m + 1)]
        return self.helper(0, 0, m, n)

    def helper(self, i, j, m, n):
        # base
        if i == m - 1 and j == n - 1:
            return 1

        if i >= m or j >= n:
            return 0

        # logic
        # right = 0
        if j < n and self.dp[i][j + 1] == 0:
            self.dp[i][j + 1] = self.helper(i, j + 1, m, n)
        if i < m and self.dp[i + 1][j] == 0:
            self.dp[i + 1][j] = self.helper(i + 1, j, m, n)

        return self.dp[i][j + 1] + self.dp[i + 1][j]

'''
Using recursion brute force
Time: O(2^mn)
Space: Recursive Stack

'''

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:

        return self.helper(0, 0, m, n)

    def helper(self, i, j, m, n):
        # base
        if i == m - 1 and j == n - 1:
            return 1

        if i >= m or j >= n:
            return 0

        # logic
        # right = 0
        right = self.helper(i, j + 1, m, n)
        # down = 0
        down = self.helper(i + 1, j, m, n)

        return right + down