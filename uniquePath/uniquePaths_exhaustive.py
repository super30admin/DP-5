'''
Time Complexity : 0(2^(mn))
Space Complexity : Recursion Stack 0(m+n)
On LeetCode: Time Limit Exceed
'''

class Solution:
    
    def __init__(self):
        self.grid = None
    
    def exhaustiveDfs(self,m,n):
        # base-case
        if (m < 0 or m == len(self.grid)) or (n<0 or n==len(self.grid[0])):
            return
        
        # logic-case
        # increase the value of the position
        if self.grid[m][n] == None:
            self.grid[m][n] = 1
        else:
            self.grid[m][n] += 1
        
        # dfs on rhs
        self.exhaustiveDfs(m,n+1)
        
        # dfs bottom
        self.exhaustiveDfs(m+1,n)
    
    def uniquePaths(self, m: int, n: int) -> int:
        
        # initlize a grid
        self.grid = [[None for col in range(0,n)] for row in range(0,m)]
        
        # peform exhaustive dfs
        self.exhaustiveDfs(0,0)
        
        # return the result
        return self.grid[-1][-1]