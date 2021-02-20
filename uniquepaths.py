# Brute force Solution:
class Solution:

    """
    Time Complexity: O(m^2 n^2)
    Space Complexity: O(1)
    
    Leetcode: Time Limit Exceeded
    """

    def uniquePaths(self, m: int, n: int) -> int:
        return self.helper(m, n, 0, 0)

    def helper(self, m, n, i, j):

        # Base
        if i == m or j == n: return 0
        if i == m - 1 and j == n - 1: return 1

        # logic
        return self.helper(m, n, i + 1, j) + self.helper(m, n, i, j + 1)

# Optimized Solution: Using DP Matrix:
class Solution:
    
    """
    Description: find number of unique paths
    
    Time Complexity: O(mn)
    Space Complexity: O(mn)
    
    Approach: Use DP matrix
    - start matrix with 1s
    - add above and left element to find next value in dp matrix
    - last value results in total number of paths
    """
    
    def uniquePaths(self, m: int, n: int) -> int:
        
        dp = [[1 for __ in range(n)] for __ in range(m)]
        
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
        
        return dp[m - 1][n - 1]
