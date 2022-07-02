# Time Complexity : O(mn) where m is the num of row and n is the cols
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : Yes
# We create a matrix of mxn and fill it with 1. Then we iterate through them
# and add them from their directions.
# Then we can finally return the last cells and get the total no. of paths.
class Solution:
    """
    we can solve this problem using dynamic programming
    """
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1 for _ in range(n)] for _ in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[-1][-1]
