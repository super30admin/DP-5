#Time Complexity: O(mxn)
#Space Complexity: O(mxn)

#--------------------------------------Using DP--------------------------------------------
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n == 0: return 0
        if m == 1 or n == 1: return 1
        memo = [[None for i in range(n)] for j in range(m)]
        return self.helper(memo, 0, 0, m, n)
        
    def helper(self, memo, i, j, m ,n):
        #base
        if i == m-1 and j == n-1: 
            return 1
        if i == m or j == n: 
            return 0
        #logic
        if memo[i][j] == None: 
            memo[i][j] = self.helper(memo, i, j+1, m, n) + self.helper(memo, i+1, j, m, n)
            
        return memo[i][j]

#------------------------Using Recursion()Polynomial Solution-----------------------------
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n == 0: return 0
        if m == 1 or n == 1: return 1
        return self.helper(0, 0, m, n)
        
    def helper(self, i, j, m ,n):
        #base
        if i == m-1 and j == n-1: 
            return 1
        if i == m or j == n: 
            return 0
        
        #logic
        return self.helper(i, j+1, m, n) + self.helper(i+1, j, m, n)