class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[None for i in range(n)] for j in range(m)]
        dp[-1][-1] = 1
        
        # for i in range(n): 
        #     for j in range(m): 
        #         m = 
        
        for i in range(m)[::-1]: 
            for j in range(n)[::-1]: 
                if i == m - 1 or j == n- 1: 
                    dp[i][j] = 1
                
                else: 
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1]
        
        return dp[0][0]
