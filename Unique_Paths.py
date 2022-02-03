class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        """
        Unique Paths
        Time complexity : O(MN)
        Space Complexity : O(MN)
        """
        
        self.dp = [[1 for i in range(n)] for j in range(m)]
        
        for i in range(1, m):
            for j in range(1, n):
                self.dp[i][j] = self.dp[i-1][j] + self.dp[i][j-1]
        return self.dp[-1][-1]
                
        
#         def dfs(index):
#             if index[0] >= m or index[1] >= n:
#                 return
#             elif index[0] == m-1 and index[1] == n-1:
#                 self.final += 1
#                 return
            
#             dfs((index[0]+1,index[1]))
#             dfs((index[0],index[1]+1))
#             return
        
        dfs((0,0))
        return self.final
            
                
        