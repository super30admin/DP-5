# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Approach : DP - tabulation
# 1. Create a matrix of size m*n
# 2. Fill the last row and last column with 1
# 3. Iterate through the matrix in reverse order
# 4. Fill the matrix with the sum of the right and down cells. This is because the number of possible paths to reach the end of the matrix from a given cell is equal to the sum of the number of possible paths from the cell to the right and the cell below it.
# 5. Return the value of the first cell
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # Initialize the matrix with 0s
        matrix = [[0 for _ in range(n)] for _ in range(m)]
        # Iterate through the matrix in reverse order
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                # Fill the last row and last column with 1
                if i == m-1 or j == n-1:
                    matrix[i][j] = 1
                # Fill the matrix with the sum of the right and down cells
                else:
                    matrix[i][j] = matrix[i][j+1] + matrix[i+1][j]
        # Return the value of the first cell
        return matrix[0][0]

# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Approach : DP - memoization
# 1. Create a matrix of size m*n
# 2. Create a dfs function that takes the current cell as an argument
# 3. If the current cell is out of bounds, return 0
# 4. If we have reached the last cell, return 1
# 5. If the current cell has already been calculated, return the value from the matrix
# 6. Call the dfs function for the right and down cells
# 7. Store the result in the matrix and return it
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        matrix = [[0 for _ in range(n)] for _ in range(m)]
        def dfs(i, j):
            if i == m or j == n:
                return 0
            if i == m-1 and j == n-1:
                return 1

            if matrix[i][j] != 0:
                return matrix[i][j]

            case0 = dfs(i+1, j)
            case1 = dfs(i, j+1)

            matrix[i][j] = case0+case1
            
            return case0+case1

        return dfs(0, 0)

# Brute force approach: DFS
# Time complexity: O(2^(m+n))
# Space complexity: O(1)
# Doesn't run on Leetcode - TLE
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        self.count = 0
        def dfs(i, j):
            if i == m or j == n:
                return
            if i == m-1 and j == n-1:
                self.count += 1
                return

            dfs(i+1, j)
            dfs(i, j+1)

        dfs(0, 0)
        return self.count