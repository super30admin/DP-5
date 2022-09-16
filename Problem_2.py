"""
Problem2: (https://leetcode.com/problems/unique-paths/)
"""

# APPROACH - 1

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        """
        This is brute force approach, using recursion to take every rout.
        Time Complexity : 
        """
        
        def helper(row, col, m, n):
           
            
            # Base Case
            if (row == m or col == n): return 0
            if (row == m-1 and col == n-1): return 1
            
            # Recursive case
            
            bottom_right = helper(row + 1, col, m, n)
            
            top_left = helper(row, col + 1, m, n)
            
            return bottom_right + top_left
        
        return helper(0 , 0, m , n)
        
# Approach - 2

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        """
        Top down DP with Memoization. 
        Time Coplexity : O(M * N)
        Space Complexity : O(M * N)
        """
        memo = [[0 for _ in range(n)]for i in range(m)]
        
        def helper(row, col, m, n):
            nonlocal memo
           
            # Base Case
            if (row == m or col == n): return 0
            if (row == m-1 and col == n-1): return 1
            
            # Recursive case
            # Case - 1
            bottom_right = 0
            if (row < m - 1):
                if memo[row + 1][col] == 0:
                    memo[row + 1][col] = helper(row + 1, col, m, n)
                bottom_right = memo[row + 1][col] 
            
            # Case - 2
            top_left = 0
            if (col < n - 1):
                if memo[row][col + 1] == 0:
                    memo[row][col + 1] = helper(row, col + 1, m, n)
            
                top_left =  memo[row][col + 1]
            
            return bottom_right + top_left
        
        return helper(0 , 0, m , n)

# approach - 3

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        """
        using bottom up dp
        TC : O(M * N)
        SC: O(M+N)
        """
        if m < n : return self.uniquePaths(n, m)
        
        dp = [0 for _ in range(n)]
     
        
        for i in range(n):
            dp[i] = 1
            
        for i in range(m-2, -1, -1):
            for j in range(n-2, - 1, -1):
                dp[j] = dp[j] + dp[j + 1]
                
        
        return dp[0]
            
        