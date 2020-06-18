#TC:O(mxn)
#SC:O(mxn)
#Ran successfully on leetcode:yes
#Algorithm:
#1.Set the first row as 1 as initializing path form that location. 
#2.Set dp[i ]as sum of its digonal elements in the array.
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[[1]*n for _ in range(m)]
        print(dp)
        
        for i in range(1,m):
            for j in range(1,n):
                dp[i][j]=dp[i-1][j]+dp[i][j-1]
        print(dp)
        return dp[m-1][n-1]
    
