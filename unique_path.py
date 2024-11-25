"""
Approach1: exhaustive approach.
TC:
Approach2: top-down DP (memoization). Solving the bigger problem.
 Recursion is happening and on the way of returning back we store the results of smaller sub-problems.
 So that when the same problem comes again we dont solve it.
 Computaiton: Lazy, solve the probelm at the end
 Space: Depends on recursion depth + memo
 The DS would depend on the problem.
 TC:  and space:

Apprach3: bottom-up DP (tabulation). Solve the smaller sub-problem.
Computaiton: eager, solve the probelm from the begining
TC: O(m*n) and space: O(m*n)
Space: Entire DP table

"""


class Solution_tabulation:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for _ in range(n)] for _ in range(m)]

        for i in range(m):
            for j in range(n):
                if i == 0 or j == 0:
                    dp[i][j] = 1

                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

        return dp[m - 1][n - 1]

class Solution_memoization:
    def helper(self, i, j, m, n, memo):
        # base case
        # valid case
        if i == m - 1 and j == n - 1:
            return 1

        # in valid case
        if i < 0 or i >= m or j < 0 or j >= n:
            return 0

        # if the problem is solved, dont visit
        if memo[i][j] != 0:
            return memo[i][j]

        left = self.helper(i + 1, j, m, n, memo)
        right = self.helper(i, j + 1, m, n, memo)

        # while returning the recursion from both the sides store the result.
        memo[i][j] = left + right
        return memo[i][j]

    def uniquePaths(self, m: int, n: int) -> int:
        memo = [[0 for _ in range(n)] for _ in range(m)]
        uniq_path = self.helper(0, 0, m, n, memo)
        return uniq_path


class Solution_exhaustive:
    def helper(self, i, j, m, n):
        # base case
        if i == m-1 and j == n-1:
            self.ans += 1
            return

        # recursive case
        if i >= 0 and i < m and j >= 0 and j < n:
            self.helper(i, j+1, m, n)
            self.helper(i+1, j, m, n)


    def uniquePaths(self, m: int, n: int) -> int:
        self.ans = 0
        self.helper(0,0, m, n)
        return self.ans