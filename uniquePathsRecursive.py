class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.helper(m,n,0,0)
    
    def helper(self, m, n, i ,j):
        #base
        if i==m or j==n:
            return 0
        
        if i==m-1 and j==n-1:
            return 1
    
        #logic
        return self.helper(m,n,i+1,j) + self.helper(m, n, i, j+1)
    
    #recursive solution, exponential time complexity with lots of repeated sub problems.
        
        
        
