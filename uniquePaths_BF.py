"""
Time complexity O(2^MN)
Brute Force- Time limit exceeded

"""

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.helper(0,0,m,n)
    
    
    def helper(self,i,j,m,n):
        if i==m-1 and j==n-1:
            return 1
        if(i>=m or j>=n):
            return 0
        
        return self.helper(i+1,j,m,n)+self.helper(i,j+1,m,n)
        
        
        
        
        
       
        