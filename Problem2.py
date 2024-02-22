# Time Complexity :O(m * n)
# Space Complexity :O(m * n)
# Did this code successfully run on Leetcode :yes


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        memo = {}
        return self.helper(0, 0, m, n, memo)

    def helper(self, r, c, m, n, memo):
        if r == m or c == n:
            return 0
        
        if r == m-1 and c == n-1:
            return 1
        
        if (r, c) in memo:  
            return memo[(r, c)]

        right = self.helper(r, c+1, m, n, memo)
        down = self.helper(r+1, c, m, n, memo)
        memo[(r, c)] = right + down
        return right + down
        