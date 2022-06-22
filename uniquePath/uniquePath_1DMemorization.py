'''
Time Complexity : 0(m*n)
Space Complexity : 0(1)
On LeetCode: Yes
'''
class Solution:
    
    def __init__(self):
        self.grid = None
    
    def memorization1D(self,m,n,rowCount):
        
        while m < rowCount:
            # above will be the same position
            # behind will be index-1 position
            for col in range(n,len(self.grid)):
                self.grid[col] = self.grid[col] + self.grid[col-1]
            
            # print(self.grid)
            # increase m
            m += 1
    
    def uniquePaths(self, m: int, n: int) -> int:
        
        # initialize grid
        # set row-0 and col-0 to value 1
        self.grid = [1 for col in range(0,n)]
        
        # perform 1D memorization        
        self.memorization1D(1,1,m)
        
        # print the result
        return self.grid[-1]