# TC:O(m*n)
# SC : O(n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m ==0 or n == 0:
            return 0
        dp = [1]*n
        
        for i in range(m-2, -1, -1):
            for j in range( n-2, -1 ,-1):
                dp[j] = dp[j] + dp[j+1]
  
      

        return dp[0]
