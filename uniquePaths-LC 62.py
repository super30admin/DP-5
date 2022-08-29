

# DP Solution with space optimization - 1D array
# Time Complexity = O(m * n)
# Space Complexity = O(n)


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n == 0:
            return 0
        
        dp = [1 for j in range(n)] 
        
        # Skipping m-1 row and n-1 col coz they are all 1's
        for i in range(m - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                dp[j] = dp[j+1] + dp[j]      # right + bottom elem
                
        
        return dp[0]



# DP using memoization
# Time Complexity = O(m * n)
# Space Complexity = O(m * n)


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n == 0:
            return 0
        
        self.dp = [[0 for j in range (n)] for i in range (m)]
        
        return self.dfs(0, 0, m, n)
    
    
    def dfs(self, i, j, m, n):
        # Base Case
        if i == m or j == n:
            return 0
        if i == m - 1 and j == n - 1:
            return 1
        
        
        # Logic
        right = 0
        if j + 1 < n:
            if self.dp[i][j + 1] != 0:
                right = self.dp[i][j + 1]
                
            else:
                right = self.dfs(i, j+1, m, n)
                
            self.dp[i][j + 1] = right
            
        
        bottom = 0
        if i + 1 < m:
            if self.dp[i + 1][j] != 0:
                bottom = self.dp[i + 1][j]
        
            else:
                bottom = self.dfs(i+1, j, m, n)
            
            self.dp[i + 1][j] = bottom
            
        
        return right + bottom




# DP Solution
# Time Complexity = O(m * n)
# Space Complexity = O(m * n)


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n == 0:
            return 0
        
        dp = [[0 for j in range(n + 1)] for i in range(m + 1)]
        dp[m][n-1] = 1
        
        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                dp[i][j] = dp[i][j+1] + dp[i+1][j]      # right + bottom elem
                
        
        return dp[0][0]
        
        

# Exhaustive - Time Limit Exceeded
# Time Complexity = exponential = 2^(m*n), 2 directions - m, n. (Grid = m*n)


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 or n == 0:
            return 0
        
        return self.dfs(0, 0, m, n)
    
    
    def dfs(self, i, j, m, n):
        # Base Case
        if i == m or j == n:
            return 0
        if i == m - 1 and j == n - 1:
            return 1
        
        
        # Logic
        return self.dfs(i + 1, j, m, n) + self.dfs(i, j + 1, m, n)
