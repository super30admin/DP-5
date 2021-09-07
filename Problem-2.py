"""
TC: O(mn)
SC: O(mn)
"""
class Solution:
    # for recursive soltuion....
    '''
    def helper(self, i, j):
        #if i == 0 and j == 0:
        #   return 0
        if i == 0 or j == 0:
            return  1
        return self.helper(i-1,j) + self.helper(i,j-1)
    '''
    def uniquePaths(self, m: int, n: int) -> int:
        # iterative solution....
        #mat = [[0 for x in range(n)] for y in range(m)]
        '''
        for i in range(n):
            mat[0][i] = 1
        for j in range(m):
            mat[j][0] = 1
        
        for i in range(1,m):
            for j in range(1,n):
                mat[i][j] = mat[i-1][j] + mat[i][j-1]
        print (mat)
        return mat[m-1][n-1]
        
        return self.helper(m-1,n-1)
        
        # space optimized solution
        mat = [1 for _ in range(n)]
        for i in range(m-1):
            for j in range(1,n):
                mat[j] += mat[j-1]
        return mat[n-1]
        '''
        #combinatorics
        fn = m+n-2
        fk = n-1
        from math import factorial
        return int(factorial(fn)/(factorial(fk)*(factorial(fn-fk))))
        