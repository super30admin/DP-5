# Time Complexity : O(MN)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode : Yes 
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        """
        dpArr.. every cell is just top + left 
        """
        dp = [[1 for i in range(n)] for i in range(m)]
        
        for i in range(1,m):
            for j in range(1,n):
                dp[i][j] = dp[i-1][j]+dp[i][j-1]
        
        return dp[-1][-1]