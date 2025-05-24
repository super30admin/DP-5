'''
// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[[0]*n for i in range(m)]

        for i in range(m):
            for j in range(n):
                if i==0 or j==0:
                    dp[i][j]=1
                elif i>0 or j>0:
                    dp[i][j]+=(dp[i-1][j]+dp[i][j-1])   

        return dp[m-1][n-1]