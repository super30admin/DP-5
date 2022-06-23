#Time Complexity : O(mn)
#Space Complexity: O(n)
class Solution:
    
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [0]*(n+1)
        
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                
                if i == m-1 and j == n-1:
                    dp[n-1] = 1
                else:   
                    dp[j] = dp[j+1]+ dp[j]
                    
        return dp[0]
                    