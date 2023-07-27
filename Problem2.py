#Time complexity is: O(m*n)
#Space complexity is O(n)
#Code ran successfully on leetcode
#No issues faced while coding
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        #initializing a sigle dimensional array of size n
        dp=[0 for i in range(n)]
        #last row
        #We are making last row values as one since there will be only
        #one direction to move
        for j in range(0,n):
            dp[j]=1
        #We will be doing buttom up aproach
        #Finding the values of the previous rows and columns
        for i in range(m-2,-1,-1):
            for j in range(n-2,-1,-1):
                #We will adding the value in the right and the buttom
                dp[j]=dp[j]+dp[j+1]
        #FInally we will returning dp[0]
        return dp[0]