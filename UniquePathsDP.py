'''
TC: O(m*n) - m and n are ROWS and COLS respectively
SC: O(m*n) - to create initial matrix and modifying it to result
'''
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        matrix = [[1 for _ in range(n)] for _ in range(m)]
        for i in range(m-2,-1,-1):
            for j in range(n-2,-1,-1):
                matrix[i][j] = matrix[i+1][j] + matrix[i][j+1]
        return matrix[0][0]
s = Solution()
print(s.uniquePaths(3,7))
print(s.uniquePaths(3,2))