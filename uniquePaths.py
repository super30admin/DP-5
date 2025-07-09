# TimeComplexity:O(m x n)
# SpaceComplexity:O(n)


# Approach:
# BruteForce:start at source you have 2options go right  or go down then you 2 options again ssee if you are hitting target or not O(2^(m+n))
# Optimal:you are exploring same path muliple time this can be found out in tree  so dp start from bottom and go up at every point(other tha borders) you total path is sum of twopaths
#    dp[i][j]=dp[i+1][j]+dp[i][j+1]
# space Optimal: when you check dp equation you only need two values .right and below so we can override same row again and again be careuful with default vals whilwe using single dp
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[1 for i in range(n)]
        
        dp[-1]=1

        for i in range(m-2,-1,-1):
            for j in range(n-2,-1,-1):
                dp[j]+=dp[j+1]
        return dp[0]




class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[[0 for i in range(n)] for _ in range(m)]
        for i in dp:
            i[-1]=1
        dp[-1]=[1 for i in range(n+1)]

        for i in range(m-2,-1,-1):
            for j in range(n-2,-1,-1):
                dp[i][j]=dp[i+1][j]+dp[i][j+1]
        return dp[0][0]


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        #this is recursion
        def helper(r,c):
               #[r]][c]
               if r==m-1 and c==n-1:return 1
               if r>=m or c>=n: return 0
               

               #logic
               return helper(r+1,c)+helper(r,c+1)
        return helper(0,0)
               
