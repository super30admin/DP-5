#Time:O(m*n)
#space:O(m*n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        
        if m==0 and n == 0:
            return 1
        dp_matrix = [[1 for _ in range(n)] for _ in range(m)]
        for i in range(1,m):
            for j in range(1,n):
                dp_matrix[i][j] = dp_matrix[i-1][j]+dp_matrix[i][j-1]
        return dp_matrix[m-1][n-1]