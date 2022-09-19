# Time Complexity: O(mn)
# Space Complexity: O(mn) for 2D array and min(O(n), O(m)) for using a single 1D array
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if n>m:
            return self.uniquePaths(n,m) # Make sure that n is the smaller of the two so we take less space
        dp = [0 for _ in range(n)]
        dp[0] = 1
        # curr = 1
        for i in range(1,m+1):
            for j in range(1,n):
                dp[j] = dp[j] + dp[j-1]
                dp[j] = dp[j]
        # print(dp,curr)
        return dp[n-1]
        
        
        # dp = [[0 for x in range(n)] for y in range(m)]
        # dp[0][0] = 1
        # for i in range(m):
        #     dp[i][0] = 1
        # for j in range(n):
        #     dp[0][j] = 1
        # for i in range(1,m):
        #     for j in range(1,n):
        #         dp[i][j] = dp[i][j-1]+dp[i-1][j]
        # return dp[m-1][n-1]