# Time Complexity : O(N*M) where N is the number of intervals
# Space Complexity : O(N*M) where N is the number of intervals
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using recursion with memoization to store the already calculated values
# I am using a bottom up approach to calculate the number of unique paths
# I am using a helper function to calculate the number of unique paths from the last cell to the first cell
# If we reach the first row or first column, we return 1 as there is only one way to reach the first cell
# If we go out of bounds, we return 0 as there is no way to reach the first cell from there
# I am storing the calculated values in a dictionary to avoid recalculating them
# At each cell, we can either come from the left or from the top, so we add the number of ways to reach the cell from both directions
# Finally, we return the number of unique paths to reach the last cell


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        memoisation = {}
        def helper(i,j):
            if i == 0 or j == 0:
                return 1
            if i < 0  or j < 0:
                return 0
            if (i,j)in  memoisation:
                return memoisation[(i,j)]
            case0 = helper(i,j-1)
            case1 = helper(i-1,j)
            memoisation[(i,j)] = case0 + case1
            return memoisation[(i,j)]
        return helper(m-1,n-1)