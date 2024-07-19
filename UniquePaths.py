# Time Complexity:
# O(m*n)

# Space Complexity:  
# O(n)  , n = length of DP array = n from mxn grid

# Approach: 
# Use Dynamic Programming.
# Initiate a 1D  array with all 1's (This simulates the last row of the grid, which mentions that each cell in this row has only 1 path from current cell to the "End")
# Run outer loop for m times:
# For each m, start filling the elements in DP array from second last index to 0 th index(reverse order).
#   Formula:  dp[j] = dp[j] + dp[j+1]
# Finally return the DP[0], which will contain all unique ways to reach from Start to End in m8n grid.


class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        # Approach 2: Dynamic Programming   TC = O(m*n), SC = O(n)
        if m == 0 or n ==0:
            return 0

        # make a 1d array with 1's
        dp = [1 for j in range(n)] 
       
        # start iterating the m*n grid leaving the last row and last col
        for i in range(m-2, -1, -1):
            for j in range(n-2, -1, -1):
                dp[j] = dp[j] + dp[j+1]
                
        return dp[0]


