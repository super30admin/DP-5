"""
1. To go right or down on any cell in 1st row and 1st column, we can only do in one way
2. for any other cell, we can reach there either from top or from left
3. We initialize a dp array with mxn 1s
4. For cells not belonging to 1st row or 1st column, we can reach there either from top or from left recursively 
   computing them and storing them in dp array 
5. Finally we return dp[m-1][n-1]

TC: O(m*n)
SC: O(m*n) + O(m+n) -> recursion stack space + dp array
"""
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        dp = [[1] * n for _ in range(m)]

        for row in range(1, m):
            for col in range(1, n):
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1]
            
        return dp[m-1][n-1]