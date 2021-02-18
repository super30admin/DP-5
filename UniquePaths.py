'''
    Time Complexity:
        O(mn)

    Space Complexity:
        O(mn)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        At each step, you can either go row - 1 or col - 1.
        Memoize the overlapping subproblems.
'''

class Solution:
    def __init__(self):
        self.dp = {}

    def uniquePaths(self, m: int, n: int) -> int:
        return self.travel_paths(m, n)

    def travel_paths(self, m, n):
        if m == n == 1:
            return 1

        if m == 0 or n == 0:
            return 0

        if (m, n) in self.dp:
            return self.dp[(m, n)]

        if (n, m) in self.dp:
            return self.dp[(n, m)]

        self.dp[(m, n)] = self.travel_paths(m - 1, n) + self.travel_paths(m, n - 1)
        return self.dp[(m, n)]
