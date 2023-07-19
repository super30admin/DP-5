# Time Complexity : O(N) for each operation.
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to use dp and generate all paths and store it in previous index.

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[0]*(n)
        for j in range(n):
            dp[j]=1
        for i in range(m-2,-1,-1):
            for j in range(n-2, -1,-1):
                dp[j]=dp[j]+dp[j+1]
        return dp[0]