"""
time: O(M*N)
space: O(N)
"""

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        row = [1] * n #theres 1 way from the bottom row
        if not n or not m:
            return 0
        for rows in range(1,m):
            for cols in range(1,n):
                row[cols] += row[cols - 1]
        return row[-1]