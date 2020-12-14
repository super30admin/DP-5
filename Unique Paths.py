# Time:- O(m*n)
# Space:- O(m*n)
# Approach:- Its pretty straitforward. At the statrting point of the grid we say that total number of way to reach the end node will be equal to the total number of ways from the first right cell to reach the end node + total number of ways to reach the end node from the bottom cell. If we recurse on this we find the total number of paths.
class Solution:
    @lru_cache(maxsize=None)
    def uniquePaths(self, m: int, n: int) -> int:
        if m==0 or n==0:
            return 0
        if m==1 and n==1:
            return 1
        return self.uniquePaths(m-1,n)+self.uniquePaths(m,n-1)
        