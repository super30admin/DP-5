#Brutforce
#Time O(2^n), space O(m+n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        return self.helper(0,0,m,n)

    def helper(self,i,j,m,n):
     #Base   
        if i==m or j==n:
            return 0
      #Base  
        if i==m-1 and j==n-1:
            return 1
      #Right and down recursion call  
        rp=self.helper(i,j+1,m,n)
        dp=self.helper(i+1,j,m,n)
        
        return rp+dp
