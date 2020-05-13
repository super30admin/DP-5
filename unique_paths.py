"""
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""

class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        Idea 
        - Each value of the cell in dp corresponds to number of ways required
        to reach that cell
        - dp[i][j] = dp[i][j-1] + dp[i-1][j]
        - return dp[m][n]
        
        m = 3, n = 2
        dp 
            0 0
            0 0
            0 0
        
        """
        dp = [[0 for _ in range(n+1)] for _ in range(m+1)]
        dp[0][1] = 1
        
        for i in range(1,m+1):
            for j in range(1,n+1):
                dp[i][j] = dp[i][j-1] + dp[i-1][j]
        return dp[-1][-1]