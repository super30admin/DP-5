# Time Complexity :O(mn)
# Space Complexity :O(mn)
# Leet Code: Yes

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for _ in range(n)] for _ in range(m)]
        dp[m-1][:] = [1 for _ in range(n)] 
        for i in range(m):
            dp[i][n-1] = 1
        if m-2>=0:
            for i in range(m-2, -1, -1):
                if n-2>=0:
                    for j in range(n-2, -1, -1):
                        dp[i][j] = dp[i+1][j] + dp[i][j+1]

        return dp[0][0]