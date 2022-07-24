# Time Complexity: O(2^mn)
# Space Complexity: O(m+n)
# DFS
class Solution:
    # def uniquePaths(self, m: int, n: int) -> int:
    #     return self.dfs(0,0,m,n)
    # def dfs(self,i: int, j: int,m: int, n: int):
    #     if i==m-1 and j==n-1: return 1
    #     if i>m-1 or j>n-1: return 0
    #     down=self.dfs(i+1,j,m,n)
    #     right=self.dfs(i,j+1,m,n)
        # return down+right
# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# DP
    # def uniquePaths(self, m: int, n: int) -> int:
    #     dp=[[0 for j in range(n+1)] for i in range(m+1)]    
    #     dp[m-1][n-1]=1
    #     for i in range(m-1,-1,-1):
    #         for j in range(n-1,-1,-1):
    #             if i==m-1 and j==n-1:continue
    #             dp[i][j]=dp[i+1][j]+dp[i][j+1]
    #     return dp[0][0]
# Time Complexity: O(m*n)
# Space Complexity: O(n)
# DP
    # def uniquePaths(self, m: int, n: int) -> int:
    #     dp=[1 for j in range(n+1)] 
    #     dp[n]=0
    #     for i in range(m-2,-1,-1):
    #         for j in range(n-1,-1,-1):
    #             dp[j]=dp[j+1]+dp[j]
    #     return dp[0]
# Time Complexity: O(2^mn)
# Space Complexity: O(m+n)
# DFS
    def uniquePaths(self, m: int, n: int) -> int:
        self.memo=[[0 for j in range(n+1)] for i in range(m+1)]
        return self.dfs(0,0,m,n)
    def dfs(self,i: int, j: int,m: int, n: int):
        if i==m-1 and j==n-1: return 1
        if i>m-1 or j>n-1: return 0
        right=0
        if self.memo[i][j+1]==0:
            self.memo[i][j+1]=self.dfs(i,j+1,m,n)
        bottom=0
        if self.memo[i+1][j]==0:
            self.memo[i+1][j]=self.dfs(i+1,j,m,n)
        down=self.memo[i+1][j]
        right=self.memo[i][j+1]
        return down+right
            