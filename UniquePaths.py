# Time Complexity : O(M*N)
# Space Complexity : O(M*N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Top Down DP Approach since there are repeated sub problems. Initialize the dp array m*n with all 1s
# Iterate over the rows and columns and since we can only go right and down we need to take the sum of the previous row and previous column that is leading to the current path
# Lastly we need to return the end or rows and columns


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if not m or not n:
            return None
        dp = [[1 for i in range(n)] for j in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        return dp[-1][-1]