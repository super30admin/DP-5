# // Time Complexity :O(n*m)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes 
# // Any problem you faced while coding this :NO
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        rows, cols = m, n
        
        path_dp = [ [ 1 for j in range(cols)] for i in range(rows) ]
         for i in range(1, rows):
            for j in range(1, cols):
                
                path_dp[i][j] = path_dp[i][j-1] + path_dp[i-1][j]
        
        
        # Destination coordination = (rows-1, cols-1)
        return path_dp[rows-1][cols-1]

