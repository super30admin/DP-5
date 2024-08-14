#// Time Complexity : O(m * n) 
# // Space Complexity : O(m * n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.
class Solution:

    def uniquePaths(self, m: int, n: int) -> int:

        dp = [[0 for _ in range(n)] for _ in range(m)]
         #dp[i][j] represents the number of unique paths to reach the cell (i, j) in an m x n grid.
        
        for i in range(m):  

            dp[i][0] = 1    # Base case: There is only one way to get to any cell in the first row (move straight right)
        
        for j in range(n):  # Base case: There is only one way to get to any cell in the first column (move straight down)
        
            dp[0][j] = 1
        
       
        for i in range(1, m):
            for j in range(1, n):
                # The cell value is the sum of the values from the cell above and the cell to the left
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        
        # The bottom-right cell contains the number of unique paths
        return dp[m-1][n-1]

# Approach:
# The problem can be solved using dynamic programming. We create a 2D array dp of size m
# n, where dp[i][j] represents the number of unique paths to reach the cell (i,j) in the grid.
# We initialize the first row and first column of the dp array to 1, as there is only
# one way to reach any cell in the first row (moving right) and any cell in the first
# column (moving down).
# Then, we fill in the rest of the dp array by calculating the number of unique paths
# to each cell as the sum of the number of unique paths to the cell above and the cell
# to the left.
# The final answer is stored in the bottom-right cell of the dp array, which is dp[m-1][n-1].

