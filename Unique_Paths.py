# Approach:
# This problem is a classic dynamic programming problem. 
# We need to calculate the number of unique paths from the top-left corner to the bottom-right corner of the grid.
# The robot can only move either down or right at any point in time.
# 1. The robot must make exactly m-1 down moves and n-1 right moves to reach the bottom-right corner.
# 2. This problem boils down to choosing m-1 down moves from the total m + n - 2 moves (right and down).
# 3. The number of ways to choose m-1 down moves from m + n - 2 total moves is given by the binomial coefficient: C(m + n - 2, m - 1).
# 4. We can compute this using dynamic programming to avoid calculating factorials directly, which can be computationally expensive.

# Time Complexity: O(m * n), where m and n are the dimensions of the grid. 
# Space Complexity: O(n), we can optimize space by using a 1D array instead of a 2D array to store intermediate results.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # Create a 1D dp array with size n (number of columns)
        dp = [1] * n
        
        # Iterate over each row
        for i in range(1, m):
            # Iterate over each column (starting from the second column)
            for j in range(1, n):
                # The number of paths to dp[j] is the sum of the paths from the left (dp[j-1]) and from above (dp[j])
                dp[j] += dp[j - 1]
        
        # The bottom-right corner is dp[n-1]
        return dp[n - 1]
