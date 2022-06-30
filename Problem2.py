#Time Complexity: O(N*M)
#Space Complexity: O(N*M)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        mat = [1 for j in range(n) for i in range(1)]
        for i in range(1,m):
            for j in range(1,n):
                mat[j] = mat[j] + mat[j-1] 
                
        return mat[-1]