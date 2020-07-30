-------------------------------Unique Paths ---------------------------------------------
# Time Complexity : O(2*mn)
# Space Complexity : O(mXn)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here as we have 2 options to choose we will use recursion to calculate the number of 
# ways to reach the destination. We will call right and down recursions and add them.
 


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        def recurse(i,j,m,n):
            # base Case
            
            if i == m-1 and j == n-1:
                return 1
            
            if i>m or j>n:
                return 0
            
            # logic
            
            right = recurse(i,j+1,m,n)
            down = recurse(i+1, j, m , n)
            
            return right+down
        
        return recurse(0,0,m,n)
        
-------------------------------Unique Paths DP ---------------------------------------------
# Time Complexity : O(mXn)
# Space Complexity : O(mXn)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here as we have 2 options to choose we will have repeated sub problems as we will come to the same place
# from 2 different paths. so we will have 1 path for all the edge blocks and add the upper block and 
left block if the block is not the edge block. Return the value of the last block as a number of ways to reach the position.

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for i in range(n)] for j in range(m)]
        
        for i in range(m):
            for j in range(n):
                if i == 0 or j == 0:
                    dp[i][j] = 1
                else:
                    dp[i][j] = dp[i-1][j]+dp[i][j-1]
        
        return dp[-1][-1]