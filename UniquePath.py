'''
Solution:
1.	The recursive solution is that
	totalPath (row, col) = totalPath (row - 1, col) + totalPath (row, col - 1)
						 = 1 if only one row or one col # base case
2.	Can be solved by filling a 2D matrix or by using 1D array and manipulate values 
	accordingly.
Time Complexity:	O(m x n) for both 
Space Complexity:	O(m x n) for first solution and O(n) for second solution
-- where m is rows and n is columns
--- Passed all testcases successfully on leetcode for both the solutions.
'''

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for i in range (n)] for j in range (m)]
        if m ==0 and n == 0: 
            return 0
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if i == m-1 or j == n-1:
                    dp[i][j] = 1
                else:
                    dp[i][j] = dp[i+1][j] + dp[i][j+1]
        
        return dp[0][0]