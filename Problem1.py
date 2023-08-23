#Time Complexity :O(m*n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[0 for j in range(n+1)]
        dp[n-1]=1
        for i in range(m-1,-1,-1):
            for j in range(n-2,-1,-1):
                dp[j]=dp[j]+dp[j+1]
        return dp[0]