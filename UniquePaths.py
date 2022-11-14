# Recursive Solution
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        def helper(row, col):
            
            # base condition
            if row == m or col == n:
                return 0
            
            if row == m - 1 and col == n -1:
                return 1
            
            # Main logic
            right = helper(row, col + 1)
            down = helper(row + 1, col)
            
            return right + down
        
        return helper(0,0)


# 2 D DP solution
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        dp = [[1] * n for _ in range(m)]
        
        for i in range(1, m):
            for j in range(1, n):
                
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
                
        return dp[m-1][n-1]
    
    # Dp solution
    # Time complexity: O(M x N)
    # Space Complexity: O(M x N)
    

# 1 D DP solution
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        dp = [1] * n
        
        for i in range(1, m):
            for j in range(1, n):
                
                dp[j] = dp[j] + dp[j-1]
                
        return dp[-1]
    
    # Dp solution using less space 1 D array
    # Time complexity: O(M x N)
    # Space Complexity: O(N)
    
    
            