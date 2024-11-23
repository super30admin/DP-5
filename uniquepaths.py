#Time Complexity for both approaches: O(m×n)
#Space Complexity:
#Top-Down: O(m×n) for memoization table + O(m+n) recursion stack.
#Bottom-Up: O(m×n) for the DP table.
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
    #Top-Down DP : Memorization Approach
        self.dp = [[0]*n for i in range(m)]
        return self.helper(m,n,0,0)
    def helper(self,m,n,i,j):
        if(i==m-1 and j==n-1):
            return 1
        if(i>=m or j>=n):
            return 0
        if(self.dp[i][j]!=0):
            return self.dp[i][j] 
        case0 = self.helper(m,n,i+1,j)
        case1 = self.helper(m,n,i,j+1)
        self.dp[i][j] = case0 + case1
        return self.dp[i][j]

    #Bottom-Up DP : Tabular Approach
        dp = [[0]*n for i in range(0,m)]
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if(i==m-1 or j==n-1):
                    dp[i][j] = 1
                else:
                    dp[i][j] = dp[i+1][j]+dp[i][j+1]
        return dp[0][0]