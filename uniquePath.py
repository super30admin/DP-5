#Time Complexity: O(n)
#Space Complexity: O(n)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        dp = [[-1] * n for _ in range(m)] 
        print(dp)
        
        def solve(x, y, m, n):
            
            if x >= m or y >= n:
                return 0
            
            if x == m-1 and y == n-1:
                return 1
            
            if dp[x][y] != -1:
                return dp[x][y]
            
            else:
                
                dp[x][y] = solve(x+1, y, m, n) + solve(x, y+1, m, n)
            
            print(x,y, dp[x][y])
            return dp[x][y]
        
        
        return solve(0, 0, m , n)