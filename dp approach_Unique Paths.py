#time: O(mxn)
#space: O(mxn)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        grid=[[1 for i in range(n)] for j in range(m)]
        for i in range(m):
            for j in range(n):
                if(i!=0 and j!=0):
                    grid[i][j]=grid[i-1][j]+grid[i][j-1]
        for g in grid:
            print(g)
        return grid[m-1][n-1]