# Time Complexity: O(m+n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The problem is turned into a simple combinatorics problem. The number of unique paths is the number of ways to choose m-1 steps from m+n-2 steps.
"""

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return math.comb(m+n-2, m-1)