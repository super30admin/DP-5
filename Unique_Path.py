# Time complexity: O(N * M)
# Space complexity: O(N * M)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
		# Make a list of list with m and n which is filled with 1 
        dp = [[1] * n for i in range(m)]    
        
        # Start row and col from 1 since we have already 1 in row and col in dp list
        for col in range(1,m):
            for row in range(1, n):
				# Magic formula to solve unique path try dry run to get whole idea
                dp[col][row] = dp[col-1][row] + dp[col][row-1]
				
		# return last value of it.
        return dp[m-1][n-1]
