#Time COmplexity : O(2^N)
# Space Complexity : O(N) number of elemets in m*n array
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        
        def helper (i,j,m,n):
            if i >=m or j >=n:
                return 0
            elif i ==m-1 and j == n-1:
                return 1
            right = helper(i,j+1,m,n)
            down = helper(i+1,j,m,n)
            return right + down
        return(helper(0,0,m,n))
        
==============================================================
#Time COmplexity : O(N*M) where N is number of rows and M is number fo Columns
# Space Complexity : O(N) number of elemets in n*m array
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for x in range(m+1)] for y in range(n+1)]
        print(dp)
        dp[n-1][m-1] = 1
        for i in range(n-1,-1,-1):
            for j in range(m-1,-1,-1):
                if i == m-1 and j == n-1:
                    continue
                if(dp[i+1][j] > 0 or dp[i][j+1] > 0):
                    dp[i][j] = dp[i+1][j] + dp[i][j+1]
        return dp[0][0]
        