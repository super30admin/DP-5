"""
Brute-Force Recursion 
Time Complexity: O((mn)^2)
Space Complexity: O()
"""
class Solution:
    
    def uniquePaths(self, m: int, n: int) -> int:
        
        if not m or not n: return 0
        return self.helper(m,n, 0, 0)
    
    def helper(self, m, n, row, col):
        # Base case
        if row == m or col == n: return 0
        if row == m-1 and col == n-1: return 1
        
        # Logic
        right = self.helper(m, n, row, col+1)
        down = self.helper(m, n, row+1, col)
        
        return right + down
"""
Time Complexity: O(m*n)
Space Complexity: O(m*n) [can also be done in O(n)]
"""
class Solution:
    
    def uniquePaths(self, m: int, n: int) -> int:
        
        if not m or not n: return 0
        # Matrix of only 1 element, return 1
        if m == 1 and n == 1: return 1
        dp = [[0 for i in range(n)] for j in range(m)]
        
        # Put 1's in topmost row, as u can't go from bottom->top.
        for k in range(1, n): dp[0][k] = 1
        
        # Put 1's in leftmost column, as u can't go from right->left.
        for k in range(1, m): dp[k][0] = 1
        
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i][j-1] + dp[i-1][j]
        
        return dp[m-1][n-1]
"""
With Space Complexity: O(n)
"""
class Solution: 
    def uniquePaths(self, m: int, n: int) -> int:
        
        if not m or not n: return 0
        dp = [1] * n
        
        for row in range(m-1):  # (m-1) since first row already initialized w/ 1's
            for i in range(1, n):
                dp[i] = dp[i] + dp[i-1]
        
        return dp[n-1]