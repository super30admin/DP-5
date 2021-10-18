# // Time Complexity :O(m*n)
# // Space Complexity :O(m*n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach






class Solution:
    
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[[0 for i in range(n+1)]for j in range(m+1)]
        print(dp)
        dp[m-1][n-1]=1
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if i==m-1 and j==n-1:
                    continue
                dp[i][j]=dp[i+1][j]+dp[i][j+1]
        return dp[0][0]
                
        
        