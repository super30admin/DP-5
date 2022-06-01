#Unique Paths

# // Time Complexity :  O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[1 for i in range(n)]                                # make an array of n length                           
        for i in range(m-2, -1, -1):
            for j in range(n-2, -1, -1):
                dp[j] = dp[j]+dp[j+1]                           # check the right and bottom array and make the current array the sum of those
        return dp[0]

        