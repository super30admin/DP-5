class Solution:
    def uniquePaths(self, m, n) :
        # Using bottom up dp
        # set the base case where same col of destination or same row of destination the ways they can recah is 1
        # approach 1 : have a 2d array dp[i][j] and keep updatign the cell value by total number of ways we can reach to destination by moving right and bottom 
        # approach 2 using tabulation using a single arr to save the prev path count and curr count and in the end the totoal number of ways we reach to end is dp[0]
        # tc : O(n*m), sc : O(n)

        dp = [0]*n
        
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if i == m-1 or j == n-1:
                    dp[j] = 1
                else :
                    dp[j] = dp[j] + dp[j+1]

        return dp[0]

    
    
        



    
        