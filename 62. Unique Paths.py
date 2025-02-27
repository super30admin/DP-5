#approach 1
#time: O(m*n)
# space: O(m*n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # create dp array for the computation
        dp = [[0] * (n+1) for _ in range(m+1)]
        dp[m-1][n-1]=1
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if i== m-1 and j== n-1:
                    continue
                dp[i][j]= dp[i+1][j] + dp[i][j+1]
        return dp[0][0]
#approach 2
# use single row for dp 
#time: O(m*n)
# space: O(n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # create dp row for the computation
        dp = [0] * (n+1)
        dp[n-1]=1
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if i== m-1 and j== n-1:
                    continue
                dp[j]= dp[j+1] + dp[j]
        return dp[0]
        
