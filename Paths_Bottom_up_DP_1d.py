# Bottom up DP
# Time - O(m*n)
# Space - O(min(m,n))

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if n > m:
            return self.uniquePaths(n,m)
        # create a dp matrix of size n of all 1's
        dp = [1 for _ in range(n)]
        
        # start from the right and keep on adding values to the matrix
        for i in range(m-2,-1,-1):
            for j in range(n-2,-1,-1):
                dp[j] += dp[j+1]
        
        # return the first cell
        return dp[0]
