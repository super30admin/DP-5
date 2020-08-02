class Solution:
    
    """
        
        Name : Shahreen Shahjahan Psyche
        Time : Recursive: O(4^MN)
               Dynammic : O(MN)
               
        Space: O(MN)
        
        Passed All Test Cases : Yes
    
    """
    
    # Recursive Solution
    def recursive(self, m, n):
        
        # base case - when it reaches terminal point
        if m == 0 and n == 0:
            return 1
        up , left = 0, 0
        if n > 0:
            up = self.recursive(m, n - 1)
        if m > 0:
            left = self.recursive(m - 1, n)
        return up + left
        
    
    # Dynammic Programming Solution
    def iterative(self, m, n):
        
        grid = [[0 for i in range(n)] for j in range(m)]
        
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                # end point
                if i == m-1 and j == n-1:
                    grid[i][j] = 1
                # boundary case
                elif i == m-1:
                    grid[i][j] = grid[i][j+1]
                # boundary case
                elif j == n-1:
                    grid[i][j] = grid[i+1][j]
                else:
                    grid[i][j] = grid[i][j+1] + grid[i+1][j]
        
        return grid[0][0]
                    
        
    
    def uniquePaths(self, m: int, n: int) -> int:
        
        return self.iterative(m, n)
