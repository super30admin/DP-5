'''
TC: O(m * n)
SC: O(n)

Intuition:

Brute force: DFS + Backtracking
DP: O(m * n) => dp[i][j] = dp[i][j + 1] + dp[i + 1][j]

Optimize: two rows

Optimize: one row

'''
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        if not m:
            return 0
        
        dp = [1 for i in range(n)]
        
        for i in range(m - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                dp[j] += dp[j + 1]
        
        return dp[0]
                
        
        