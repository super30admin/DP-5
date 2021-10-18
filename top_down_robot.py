# // Time Complexity :O(m*n)
# // Space Complexity :O(m*n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach



class Solution:
    def __init__(self):
        self.table=None
    def uniquePaths(self, m: int, n: int) -> int:
        self.table=[[0 for i in range(n)]for j in range(m)]
        return self.topdown(m,n,0,0)
        
    def topdown(self,m,n,i,j):
        #base
        if i==m or j==n :
            return 0
        if i==m-1 and j==n-1:
            return 1
        #logic
        bottom=0
        if i<(m-1):
            
            if self.table[i+1][j]==0:
                print("a")
                self.table[i+1][j]=self.topdown(m,n,i+1,j)
            bottom=self.table[i+1][j]
        right=0
        if j<(n-1):
            if self.table[i][j+1]==0:
                self.table[i][j+1]=self.topdown(m,n,i,j+1)
            right=self.table[i][j+1]
        print(self.table)
        return bottom + right
        
        