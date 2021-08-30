# // Time Complexity : Exponential
# // Space Complexity : Exponential
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
#DFS Approach

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.helper(m, n, 0, 0)

    def helper(self, m, n, i, j):
        # base
        if i == m or j == n: return 0
        if i == m - 1 and j == n - 1: return 1
        # logic
        return self.helper(m, n, i, j + 1) + self.helper(m, n, i + 1, j)

# // Time Complexity : O(mn)
# // Space Complexity : O(mn)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
#DP Approach
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for i in range(n+1)] for i in range(m+1)]
        dp[m-1][n-1] = 1
        for i in range(m-1, -1,-1):
            for j in range(n-1,-1,-1):
                if i == m-1 and j == n-1: continue
                dp[i][j] = dp[i][j+1] + dp[i+1][j]
        return dp[0][0]

# // Time Complexity : O(mn)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach
#Space Optimised DP Approach
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [1 for i in range(n)]
        for i in range(m-2, -1,-1):
            right = 0
            for j in range(n-1,-1,-1):
                dp[j] = dp[j] + right
                right = dp[j]
        return dp[0]