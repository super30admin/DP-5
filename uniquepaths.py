# Brute force Solution:
class Solution:

    """
    Time Complexity: O(m^2 n^2)
    Space Complexity: O(1)
    
    Leetcode: Time Limit Exceeded
    """

    def uniquePaths(self, m: int, n: int) -> int:
        return self.helper(m, n, 0, 0)

    def helper(self, m, n, i, j):

        # Base
        if i == m or j == n: return 0
        if i == m - 1 and j == n - 1: return 1

        # logic
        return self.helper(m, n, i + 1, j) + self.helper(m, n, i, j + 1)
