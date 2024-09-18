class Solution:
    # Time/space complexity - O(m*n)/O(m*n)
    def uniquePaths(self, m: int, n: int) -> int:
        grid = [ [0]*n for _ in range(m) ]
        for i in range(m):
            for j in range(n):
                if i == 0 or j == 0:
                    grid[i][j] = 1
        for i in range(1,m):
            for j in range(1,n):
                grid[i][j] = grid[i-1][j] + grid[i][j-1]
        return grid[m-1][n-1]

        # Time/Space - O(m*n), O(n)
        grid = [1]*n
        for i in range(1,m):
            for j in range(1,n):
                grid[j] = grid[j-1] + grid[j] 
        return grid[n-1]
        
        
        
        # memo = dict()
        # def helper(i,j):
        #     if i == m or j == n: return 0
        #     if  i == m-1 and j == n-1: return 1
        #     if (i,j) in memo:
        #         return memo[(i,j)]

        #     caseR = helper(i,j+1)
        #     caseD = helper(i+1,j)
        #     memo[(i,j)] = caseR + caseD
        #     return caseR + caseD
        # return helper(0,0)

