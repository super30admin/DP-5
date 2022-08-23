class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        t=[[1 for _ in range(n)]for _ in range(m)]
        
        for row in range(1,m):
            for col in range(1,n):
                t[row][col]=t[row-1][col]+t[row][col-1]
                
        return t[m-1][n-1]