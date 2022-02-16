"""
There is a robot on an m x n grid. The robot is initially located 
at the top-left corner (i.e., grid[0][0]). The robot tries to move to the 
bottom-right corner (i.e., grid[m - 1][n - 1]). 
The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths 
that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than 
or equal to 2 * 109.

"""

# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        # Recursion with Memoization
        if m == 0 or n == 0:
            return 0
        
        self.memo = [[None] * n for i in range(m)]
        self.memo[m-1][n-1] = 1
        
        self.dfs(0, 0, m, n)
        
        return self.memo[0][0]
    
    def dfs(self, i, j, m, n):
        
        #base
        if(i==m or j==n):
            return 0
        if self.memo[i][j] is not None:
            return self.memo[i][j]
        
        #logic
        self.memo[i][j] = self.dfs(i+1, j, m, n) + self.dfs(i, j+1, m, n)
        
        return self.memo[i][j]
        
        
        
        
        