# Approach: Using recursion -- Exponential, at each cell we have 2 decisions to take, go right or go down
# Keep inc the result as there is a valid path that brings us to the destination
# Time Complexity: 2 ^ (m + n)
# Space Complexity: O(m * n) # space used in recursive call stack

def uniquePaths(self, m: int, n: int):
               
        self.result = 0
        self.helper(1, 1, m, n)
        return self.result
    
def helper(self, i, j, m, n):
    
    # base case
    if i == m and j == n: # if we have reached the end point, add to result and return to main call 
        self.result += 1
        return
    
    # bounds
    elif i > m or j > n:
        return
    
    #logic
    self.helper(i + 1, j, m, n)
    self.helper(i, j + 1, m, n)



# Approach 2
# Using DP
# Time - O(M * N)
# Space - O(M * N)

def uniquePaths(self, m: int, n: int) -> int:

    dp = [[1] * n for i in range(m)]
        
    for i in range(1,m):
        for j in range(1,n):
            dp[i][j] = dp[i-1][j] + dp[i][j-1]      
    
    return dp[m-1][n-1]
    
