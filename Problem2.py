#Time complexity: O(mn)
#Space complexity: O(mn)
#Works on leetcode: yes
#Appraoch: We initialize a mxn dp matrix with all ones as each cell counts towards one step. Each cell can be reached by 
# either from cell above it or from cell left of it, hence unique paths to current cells are dp[i][j] = dp[i-1][j] + dp[i][j-1]


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1]*n]*m
        for i in range(1,m):
            for j in range(1,n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[-1][-1]