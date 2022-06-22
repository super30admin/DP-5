'''
Time Complexity : 0(m*n)
Space Complexity : 0(m*n)
On LeetCode: Yes
'''
class Solution:
    
    def __init__(self):
        self.grid = None
    
    def memorization2D(self,m,n):
        
        for row in range(m,len(self.grid)):
            for col in range(n,len(self.grid[0])):
                # above + behind
                self.grid[row][col] = self.grid[row-1][col] + self.grid[row][col-1]
        
    
    def uniquePaths(self, m: int, n: int) -> int:
        
        # initialize grid
        self.grid = [[None for col in range(0,n)] for row in range(0,m)]
        
        # set row-0 and col-0 to value 1
        for row in range(0,m):
            self.grid[row][0] = 1
        for col in range(0,n):
            self.grid[0][col] = 1
            
    
        # perform 2D memorization        
        self.memorization2D(1,1)
        
        # print the result
        return self.grid[-1][-1]