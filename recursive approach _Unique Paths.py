#time: O(2^(mxn))
#space: O(m+n)

#recursive appraoch
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.helper(1,1,m,n)
        
    def helper(self,i,j,m,n):
        if(i==m and j==n):
            return 1
        if(i>m or j>n):
            return 0
        count = 0
        count+=self.helper(i+1,j,m,n)
        count+=self.helper(i,j+1,m,n)
        
        return count
        
        