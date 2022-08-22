# Time complexity: O(mn)
# Space complexity: O(mn)
# Approach: create a dp array of size m+1 and n+1 to take care of boundary conditions
# put dp[m-1][n] as 1
# now add the below element and right side element all the way from bottom right most to top left.
# return top left element



class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n == 0:
            return 0
        dp = [[0 for i in range(n+1)] for j in range(m+1)]
        dp[m-1][n] = 1
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                dp[i][j] = dp[i+1][j] + dp[i][j+1]
        return dp[0][0]
                
        