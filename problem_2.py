# 62. Unique Paths

# Code: 
# Approach: Add left +top val for each node. (Boundaries are 1's)

# Boundary condition looks like this:
# for m =3 and n =7:
# it would look like this::::::::

'''

 [1, 1, 1, 1, 1, 1, 1], 
 [1, 0, 0, 0, 0, 0, 0], 
 [1, 0, 0, 0, 0, 0, 0]

'''

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        dp = [[0 for i in range(n)] for j in range(m)]
        
        for i in range(m):
            for j in range(n):
                if i==0 or j == 0:
                    dp[i][j] = 1
                else:
                    dp[i][j] = dp[i-1][j]+dp[i][j-1]
                
        
        return dp[-1][-1]


# Time Complexity: O(N*M)
# Space Complexity: O(N*M)
# Accepted on Leetcode: YES.