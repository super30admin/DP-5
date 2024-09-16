# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# Approach: Initialize cost matrix to 0, 0th column to 1 and 0th row to 1.
#			Iterate over the rest of the matrice elements and update the ith,jth cost matrix value as cost_matrix[i-1][j] + cost_matrix[i][j-1]
#
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        cost_matrix = [[0] * n for i in range(m)]
        for i in range(n):
            cost_matrix[0][i] = 1
        
        for i in range(m):
            cost_matrix[i][0] = 1
            
        for i in range(1,m):
            for j in range(1,n):
                cost_matrix[i][j] = cost_matrix[i-1][j] + cost_matrix[i][j-1]
        
        return cost_matrix[m-1][n-1]