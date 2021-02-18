#Time Complexity: O(M*N)
#Space Complexity: O(M*N)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1] * (n+1)]*(m+1)
        for i in range(m-1, 0, -1):
            for j in range(n-1, 0, -1):
                dp[i][j] = dp[i+1][j] + dp[i][j+1]
                
        return dp[1][1]