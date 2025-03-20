# https://leetcode.com/problems/unique-paths/description/

#---------- recursion
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.helper(0,0,m,n)
    
    def helper(self,i,j,m,n):
        # base
        if i == m or j == n:
            return 0
        if i == m-1 and j == n-1:
            return 1

        #logic
        bottom = self.helper(i+1,j,m,n)
        right = self.helper(i,j+1,m,n)
        return bottom + right

# TC: O(2^(m+n))
# SC: O(m+n) for the recursive stack


############# DP WITH MEMOIZATION

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        self.memo = [[0] * (n+1) for _ in range(m+1)]
        return self.helper(0,0,m,n,self.memo)
    
    def helper(self,i,j,m,n,memo):
        # base
        if i == m or j == n:
            return 0
        if i == m-1 and j == n-1:
            return 1

        if self.memo[i][j] != 0:
            return self.memo[i][j]

        #logic
        bottom = self.helper(i+1,j,m,n,self.memo)
        right = self.helper(i,j+1,m,n,self.memo)
        self.memo[i][j] = bottom + right
        return bottom + right

# TC: O(mn)
# SC: O(mn) + the recursive stack


###########3 DP tabulation


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0] * (n+1) for _ in range(m+1)]
        dp[m-1][n-1] = 1
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if i == m-1 and j == n-1:
                    continue
                dp[i][j] = dp[i+1][j] + dp[i][j+1]
        
        return dp[0][0]
    
    

# TC: O(mn)
# SC: O(mn)