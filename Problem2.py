"""
// Time Complexity : in code
// Space Complexity : in code
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""

class Solution(object):
    
    """
    RECURSIVE
    Time - o(2^(m*n)) - m - no. of rows, m - no. of cols
    space - o(m*n)

    def helper(self, i, j, m,n):
        #base
        if i == m - 1 and j == n - 1 : #when we reach the finish point, return 1 as theres only one way to get to it being in the same state
            return 1
        
        if i >= m or j >= n: # out of bounds
            return 0
        #logic
        right = self.helper(i, j + 1, m, n) #get all paths from right
        bottom = self.helper(i + 1, j, m, n) #get all paths from bottom
        
        return right + bottom #return the sum
        """
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        """
        DP Solution
        time - o(m*n)
        space - o(m*n)
        """
        dp = [[0 for i in range(n)] for j in range(m)] #create the dp matrix
        
        dp[m - 1][n - 1] = 1 #set finish point to 1
        
    
        for i in range(m - 1, -1, -1): #iterate over all the elements
            for j in range(n - 1, -1, -1):
                if i + 1 < m: #if bottom exists, add the value at it 
                    dp[i][j] += dp[i+1][j]
                    
                if j + 1 < n: #if right exists, add the value at it 
                    dp[i][j] += dp[i][j+1]
                    
        return dp[0][0] #will have the sum of all the paths
        
        
        """
        #recursive functioion call
        return self.helper(0, 0, m, n)
        
        """
        
        
        