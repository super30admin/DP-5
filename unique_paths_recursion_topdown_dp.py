# Time Complexity : O(M*N) where M and N are the dimension of the grid
# Space Complexity : O(M*N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.dp = []
    def uniquePaths(self, m: int, n: int) -> int:
        self.dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        return self.pathFinder(0, 0, m, n)
    
    def pathFinder(self, i, j, m, n):
        #base
        if i == m-1 and j == n-1:
            return 1
        if i == m or j == n:
            return 0
        #logic
        if self.dp[i + 1][j] == 0:
            self.dp[i + 1][j] = self.pathFinder(i + 1, j, m, n)
        bottom = self.dp[i + 1][j]
        if self.dp[i][j + 1] == 0:
            self.dp[i][j + 1] = self.pathFinder(i, j + 1, m, n)
        right = self.dp[i][j + 1]
        return bottom + right