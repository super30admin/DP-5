# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# from bottom to top count the number of possible paths which will be the sum of
# of right and bottom cells
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        arr = [[1]*n]*m
        
        for i in range(m-2,-1,-1):
            for j in range(n-2,-1,-1):
                arr[i][j] = arr[i+1][j] + arr[i][j+1]
        
        return arr[0][0]
        