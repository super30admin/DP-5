# Time Complexity : O(m * n) [given input]
# Space Complexity : O(m*n) [given input]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m ==n and n ==1:
            return 1
        paths = [[0 for col in range(n)]  for row in range(m)]
        
        for i in range(1, n):
            paths[0][i] = 1
            
        for i in range(1, m):
            paths[i][0] = 1
            
        for i in range(1, m):
            for j in range(1, n):
                paths[i][j] = paths[i][j-1] + paths[i-1][j]
        
        return paths[m-1][n-1]