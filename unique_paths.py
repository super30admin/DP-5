# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I start with the target tile and assign it 1 in a memoization matrix. I then add bottom path + right path for each index in the memoization
# I then return the number in the the 0,0 index in the memoization matrix


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        memo = [[1 for x in range(n)] for y in range(m)]
        
        x = m-1
        y = n-1
        
        memo[x][y] = 1
        
        for i in range(x-1, -1, -1):
            for j in range(y-1, -1, -1):
                memo[i][j] = memo[i+1][j] + memo[i][j+1]
                
        return memo[0][0]
