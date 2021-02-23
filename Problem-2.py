#Time Complexity :O(mn)
#Space Complexity :O(m)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : tried running sum.
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        dp=[1]*(n+1)
        dp[n]=0
        
        for i in range(m-1):
            for i in range(len(dp)-2,-1,-1):
                dp[i]=dp[i]+dp[i+1]
        return dp[0]
            