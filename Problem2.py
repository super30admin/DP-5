#I implemented a dynamic programming approach to optimize space complexity. I used a one-dimensional array dp of size n, initialized with 1s, to store the number of ways to reach each cell in the current row. This is because in a grid, the number of ways to reach a cell is the sum of the ways to reach the cell directly above it and the cell to the left. By iterating through each row (from 1 to m-1), and each column within that row, I updated dp[j] to be the sum of its current value and pre (which holds the number of ways to reach the cell directly above the current cell). This ensures that at each cell, dp[j] reflects the total number of ways to reach that cell from the top-left corner. Finally, the number of unique paths to the bottom-right corner of the grid is given by dp[n-1]. The time complexity of this solution is O(m×n), as we iterate over each cell in the grid once. The space complexity is O(n), as we only use a single array of size n to store the number of paths for the current row.

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[1]*n
        pre=0
            
        for i in range(1,m):
            for j in range(n):
                if j==0:
                    pre=1
                else:
                    dp[j]=dp[j]+pre
                    pre=dp[j]
        return dp[n-1]