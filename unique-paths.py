"""
Runtime Complexity: O(mn) - we traverse m rows and n columns respectively to compute the total number of possible unique paths.
Space Complexity: O(mn)
Yes, the code worked on leetcode.
Issues while coding-No
"""


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n == 0:
            return 0
        dp = [[0 for i in range(n+1)]for j in range(m+1)]
        dp[m-1][n] = 1
        #print(dp)
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                dp[i][j] = dp[i+1][j]+dp[i][j+1]
        return dp[0][0]
        
        