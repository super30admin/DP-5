# TC: O(N^2)
# SC: O(N)
# Yes, it ran on leetcode
# No problems

class Solution(object):
    def uniquePaths(self, m, n):
        
        if m == 1 or n == 1:
            return 1      
        
        # O(n) Space Complexity 
        dp = [1] * n
        for i in range(1, m):
            for j in range(1, n):
                dp[j] += dp[j-1]
        return dp[n-1]
        
        """
        # O(m*n) Space Complexity 
        DP = [[1] * n for i in range(m)]
        print(DP)
        
        for i in range(1,m):
            for j in range(1,n):
                DP[i][j] = DP[i-1][j] + DP[i][j-1]      
        return DP[m-1][n-1]
        """
        