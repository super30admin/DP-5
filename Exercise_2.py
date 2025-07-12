# S30 Problem #112 Unique Paths
#LeetCode #62. https://leetcode.com/problems/unique-paths/description/

# Author : Akaash Trivedi
# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# brute force recursion - gives TLE
# robot can go right or down. and exit from bottom right.
# recursively call the helper funtion exploring all the possible options of right and down till it exit

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.helper(0,0,m,n)
    
    def helper(self, r, c, m, n):
        # base
        if r == m-1 and c == n-1:
            return 1
        if r > m or c > n:
            return 0
        # logic
        # robot go right or down
        return self.helper(r, c+1, m, n) + self.helper(r+1, c, m, n)

# memorization recursion
# robot can go right or down. and exit from bottom right.
# recursively call the helper funtion exploring all the possible options of right and down till it exit
# store this result in memorisation and stop early if path already visited

class Solution:
    def __init__(self):
        self.memo = []
    def uniquePaths(self, m: int, n: int) -> int:
        self.memo = [[0 for _ in range(n)] for _ in range(m)]
        return self.helper(0,0,m,n)
    
    def helper(self, r, c, m, n):
        # base
        if r == m-1 and c == n-1:
            return 1
        if r >= m or c >= n:
            return 0
        # path already traced
        if self.memo[r][c] != 0:
            return self.memo[r][c]
        # logic
        # robot go right or down
        res = self.helper(r, c+1, m, n) + self.helper(r+1, c, m, n)
        self.memo[r][c] = res
        return res

# bottom up DP
# Time Complexity : O(m*n)
# Space Complexity : O(n)
# initialize dp array and set the last row and last col to 1 since there is only one way to reach the exit from boundary
# for each cell dp[row][col] is sum of dp on bottom (dp[r+1][c]) and dp on right (dp[r][c+1]), representing total path to exit
# total number of unique paths stored at top left corner of matrix dp[0][0] 
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # build a dp array
        dp = [[1 for _ in range(n)] for _ in range(m)]
        for r in range(m-2, -1, -1):
            for c in range(n-2, -1, -1):
                # right dp + down dp
                dp[r][c] = dp[r+1][c] + dp[r][c+1]
        return dp[0][0]

# bottom up 1d-DP
# Time Complexity : O(m*n)
# Space Complexity : O(n)
# initialize dp array and set to 1 since there is only one way to reach the exit from boundary
# for each cell dp[col] is sum of dp on right (dp[c+1]) and itself dp[c], representing total path to exit
# total number of unique paths stored at left corner of array dp[0] 
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # build a dp array
        dp = [1 for _ in range(n)]
        for r in range(m-2, -1, -1):
            for c in range(n-2, -1, -1):
                # right dp + down dp
                dp[c] = dp[c] + dp[c+1]
        return dp[0]