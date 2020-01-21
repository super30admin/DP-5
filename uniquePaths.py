# Time Complexity : O((m*n)^2)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : Thinking about the logic and optimal solution

class Solution:
    def __helper(self, i, j, m, n):
        # Base Condition
        
        if i > m or j > n:
            return
        if i == m and j == n:
            self.count += 1
            return
        # Logic
        self.__helper(i+1, j, m, n)
        self.__helper(i, j+1, m, n)
        
    def uniquePaths(self, m: int, n: int) -> int:
        self.count = 0
        self.__helper(0, 0, m-1, n-1)
        return self.count
        