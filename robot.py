# doubt: here according to the question m is cols and n is rows if thats the case, shouldn't the condition be i >=n and j>=m. if i do that i am getting an error
# time complexity:2^(m*N)
# space: O(1)
# we make two choice at each grid and check if i and j has reached the destination
# brute force

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.helper(0, 0, m, n)

    def helper(self, i, j, m, n):
        if i >= m or j >= n:
            return 0
        if i == m - 1 and j == n - 1:
            return 1
        right = self.helper(i, j + 1, m, n)
        bottom = self.helper(i + 1, j, m, n)
        return right + bottom


# leetcode:accepted
# explinatoin: create one more dp array of size n+1 and m+1 and do bottom up approach and keep folling the matrix and end, return the starying cell (dp[0][0])
# tc:O(m*N)
# sc:o(m*N)
# doubt: here n and m have been properly evaluvated against i, why not in brute force
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for i in range(m + 1)] for j in range(n + 1)]
        dp[n - 1][m - 1] = 1
        for i in range(n - 1, -1, -1):
            for j in range(m - 1, -1, -1):
                if i == n - 1 and j == m - 1:
                    continue
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1]
        return dp[0][0]
