# Time Complexity : O(2 ^ M*N) where M and N are the dimension of the grid
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No (Time Limit Exceeded)
# Any problem you faced while coding this : No

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.pathFinder(0, 0, m, n)
    
    def pathFinder(self, i, j, m, n):
        #base
        if i == m-1 and j == n-1:
            return 1
        if i == m or j == n:
            return 0
        #logic
        return self.pathFinder(i + 1, j, m, n) + self.pathFinder(i, j + 1, m, n)