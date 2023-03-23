#All TC passed on leetcode

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:

        #Here we traverse from destination cell to source and store paths count for every cell. For each cell paths count is computed as sum of paths of cell below and right of it.
        #Time complexity - O(m*n) - traversing all cell from destination to source
        #Space complexity - O(m*n) - for storing possible paths count for every cell
        dp = [[0]*n for i in range(m)]

        #paths possible from any cell in last column is 1
        for i in range(m):
            dp[i][n-1] = 1

        #paths possible from any cell in last row is 1
        for i in range(n):
            dp[m-1][i] = 1

        #We compute no. of paths possible for each cell by taking sum of paths from cells right and below it.
        for i in range(m-2, -1, -1):
            for j in range(n-2, -1, -1):
                dp[i][j] = dp[i+1][j] + dp[i][j+1]
        
        return dp[0][0]
    


#--------------------------------------OR-------------------------------------------------
        
        #Here we call recurssive dfs on downward and rightward direction for each cell and return the added results. 
        #Time complexity - O(2^(m*n)) - from every cell 2 calls i.e. downward or rightwards are made.
        #Space complexity - O(1)
        def helper(m, n, i, j):
            if i==m-1 and j==n-1:
                return 1
            
            if i<0 or j<0 or i>=m or j>=n:
                return 0

            return helper(m, n, i+1, j) + helper(m, n, i, j+1)

        res = helper(m, n, 0, 0)
        return res
        