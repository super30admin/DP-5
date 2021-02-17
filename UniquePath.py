class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        '''
        Time, Space Complexity: O(mn)
        '''
        if(m==1 and n==1):
            return 1
        
        x = [[0 for i in range(0,n)] for j in range(0,m)]
        for i in range(1,m):
            x[i][0] = 1
        
        for j in range(1,n):
            x[0][j] = 1
        
        for i in range(1,m):
            for j in range(1,n):
                x[i][j] = x[i-1][j] + x[i][j-1]
        
        return x[-1][-1]
