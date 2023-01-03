class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # approach 1
        ## T.C = O(m.n)
        ## S.C = O(n)

        dp = [1]*n

        for i in range(1, m):
            for j in range(1, n):
                dp[j] = dp[j] + dp[j-1]
        
        return dp[-1]


        # approach 1
        ## T.C = O(m.n)
        ## S.C = O(m.n)

        mtx = [[1 if i == 0 or j == 0 else 0 for j in range(n)] for i in range(m)]

        for i in range(1, m):
            for j in range(1, n):
                mtx[i][j] = mtx[i-1][j] + mtx[i][j-1]
        
        return mtx[-1][-1]
        