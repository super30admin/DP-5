'''
BruteForce Approach(Checking all combinations using recursive approach)
TimeLimit exceeded on leetcode(62)
Time- O(2^M*N)
Space - O(1)
'''


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.helper(0, 0, m, n)  # Call helper

    def helper(self, i, j, m, n):
        # Base Case
        if i == m - 1 and j == n - 1:
            return 1
        if i >= m or j >= n:
            return 0

        # Logic
        right = self.helper(i, j + 1, m, n)  # Call recursion for right
        bottom = self.helper(i + 1, j, m, n)  # call recursion for bottom
        return right + bottom