# Brute Force Solution
# Time Complexity: O(2^n)
# Space Complexity: O(m * n)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 and n == 0:
            return 0
        return self.helper(0, 0, m, n)
        
    def helper(self, i, j, m, n):
        if (i == m or j == n):
            return 0
        if i == m-1 and j == n -1:
            return 1
        
        return self.helper(i, j+1, m, n) + self.helper(i+1, j, m, n)


# Dynamic Programming
# Time Complexity: O(m * n)
# Space Complexity: O(m * n)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 and n == 0:
            return 0
        dp = [[0 for j in range(n + 1)] for i in range(m + 1)]
        dp[m-1][n-1] = 1
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                if i == m-1 and j == n-1:
                    continue
                dp[i][j] = dp[i][j+1] + dp[i+1][j]
        return dp[0][0]
        

# Space Optimised Dynamic Programming
# Time Complexity: O(m * n)
# Space Complexity: O(n) 
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 and n == 0:
            return 0
        dp = [1 for i in range(n)]
        for i in range(m-1):
            right = 0
            for j in range(n-1, -1, -1):
                dp[j] += right
                right = dp[j]
                
        return dp[0]