# Time Complexity : O(m+n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        #Edge Case
        if(m==0 and n==0):
            return 0
        dp=[1 for i in range(n)]
        #print(dp)
        for i in range(m-2,-1,-1):
            temp=[1]
            prev=temp[0]
            for j in range(n-2,-1,-1):
                sol=dp[j]+prev
                temp.insert(0,sol)
                prev=sol
            dp=temp
            #print(dp)
        return dp[0]