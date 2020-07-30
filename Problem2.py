# Time Complexity : O(mxn) 
# Space Complexity :O(mxn) ,for dp matrix.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1 for _ in range(m)] for _ in range(n)]
        for i in range(1,n):
            for j in range(1,m):
                dp[i][j] = dp[i][j-1]+ dp[i-1][j]
                
        print(dp)
        return dp[-1][-1]