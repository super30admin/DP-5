# TC: O(2 ^ (M x N)) since at every matrix element, we explore 2 options: Path from its right element and path from its down element. 
# SC: O(H) where H is the height of the recursive stack.

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        def recurse(i, j): 
#             base 
            if i >= m or j >= n: 
                return 0
            if i == m - 1 and j == n - 1: 
                return 1 
#           logic
            return recurse(i, j + 1) + recurse(i + 1, j)

        return recurse(0,0)
