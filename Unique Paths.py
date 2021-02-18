from math import factorial as fact

class Solution:
    #Solution 1
    def uniquePaths(self, m: int, n: int) -> int:
        #Approach: Maths, P&C
        #Time Complexity: O(m + n)      // if we consider multiplication O(1)
        #Space Complexity: O(1)
        
        return fact(m + n - 2) // (fact(m - 1) * fact(n - 1))
    
    #Solution 2
    """
    def uniquePaths(self, m: int, n: int) -> int:
        #Approach: Dynamic Programming
        #Time Complexity: O(m * n)
        #Space Complexity: O(m * n)
        
        dp = [[1 for j in range(n)] for i in range(m)]
        
        for i in range(1, len(dp)):
            for j in range(1, len(dp[0])):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
                
        return dp[-1][-1]
    """
    
    #Solution 3
    """
    def uniquePaths(self, m: int, n: int) -> int:
        #Approach: Recursion
        #Time Complexity: 2 ^ (m + n)
        #Space Complexity: O(m * n)     // recursion stack under the hood
        
        self.result = 0
        self.helper(1, 1, m, n)
        return self.result
    
    def helper(self, i, j, m, n):
        print(i, j)
        #base
        if i == m and j == n:
            self.result += 1
            return
        elif i > m or j > n:
            return
        
        #logic
        self.helper(i + 1, j, m, n)
        self.helper(i, j + 1, m, n)
    """