
# // Time Complexity : O(mn)
# // Space Complexity : O(mn)
# // Did this code successfully run on Leetcode :  Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 
#DP: Initialise DP matrix with all 1s. Each cell can be reached by 
# either from 1) cell above it 2)cell left of it. The unique paths to current cells are dp[i][j] = dp[i-1][j] + dp[i][j-1]

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        dp = [[1]*n]*m
        
        for i in range(1,m):
            for j in range(1,n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        
        return dp[-1][-1] 
