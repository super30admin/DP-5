"""
Time Complexity : O(mn)
Space Complexity : O(mn)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
The only possible ways to reach a point is either from above or from left. We use this knowledge and come up 
with the DP solution.
"""


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        arr = [[1]*n]*m
        for i in range(1, m):
            for j in range(1, n):
                arr[i][j] = arr[i-1][j]+arr[i][j-1]
        return arr[-1][-1]
