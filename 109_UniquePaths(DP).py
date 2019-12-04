'''
Using dynamic programming bottom up approach - Fill in the number of paths that can reach to destination , count back from destination no. of paths.
Time - O(M*N)
Space - O(M*N)
'''


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # create a dp array
        dp = [[0 for i in range(m + 1)] for j in range(n + 1)]
        # make the position '1' where we have the actual destination.
        dp[n - 1][m - 1] = 1
        for i in range(n - 1, -1, -1):
            for j in range(m - 1, -1, -1):
                # loop through each element
                if i == n - 1 and j == m - 1:  # this element is already made 1
                    continue;
                # for rest of the dp elements add the numbers from bottom and right
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1]

        return dp[0][0]  # return the number at first position