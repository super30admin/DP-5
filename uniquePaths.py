'''
Time Complexity : O(m*n)

Space Complexity : O(m*n)

Did this code successfully run on Leetcode : Yes

Explanation: Number of unique parts would be summation of (dp[i-1][j]+dp[i][j-1]), to move from 1 cell to another at
the border ie i==0 or j ==0 would be 1 this is the Base case.
'''
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1 for i in range(0,n) ]for i in range(0,m)]
        for i in range(1,m):
            for j in range(1,n):
                 dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[m-1][n-1]