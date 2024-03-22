'''
Time Complexity - O(2^(mn)) for brute force (recursive), O(mn) for bottom up
Space Complexity - O(mn) for brute force, O(mn) for bottom up and O(n) for space optimized

Works on Leetcode
'''
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 1 and n == 1:
            return 1
        #TOP DOWN DP
        # dp = [[0 for j in range(n)] for i in range(m)] #create a DP Array
        # self.paths(0, 0, m ,n ,dp) #populate the DP Array
        # print(dp)
        # return dp[0][0] #result will be populated from down to up


        #BOTTOM UP DP
        # dp = [[0 for j in range(n)] for i in range(m)] #create the DP array
        # for j in range(n): #set top row as 1 because one can reach there by only 1 path
        #     dp[0][j] = 1 
        # for i in range(m): #set left most column as 1 as those can be reached using 1 path
        #     dp[i][0] = 1
        
        # for i in range(1,m):
        #     for j in range(1, n):
        #         dp[i][j] = dp[i-1][j] + dp[i][j-1] #for other paths it is sum of no. of paths to reach element directly above and one place left of the element
        
        # return dp[m-1][n-1] #we return the total number of paths i.e. 

        #SPACE OPTIMIZED DP
        prev = [1 for j in range(n)] #our caclulation is based on only the previous row and the current row, we maintain previous row
        for i in range(1,m):
            dp = [0 for k in range(n)] #we create temporary array to store the calculations for current row
            dp[0] = 1 #set the first element of each row as 1 as we can only there from up
            for j in range(1,n):
                dp[j] = prev[j] + dp[j-1] #calulate the no of paths for each position
            prev = dp #once we caluclate the paths for positions in entire row make it the previous
        return prev[n-1] #return the last element as it will become previous array 

    #TOP DOWN DP
    def paths(self, i, j, m, n, dp):
        if i > m-1 or j > n-1: #If we breach the boundary
            return 0
        elif i == m-1 and j == n-1: #If we are at the bottom right corner
            return 1
        elif dp[i][j] != 0: #if dp of that element has been populated return the value
            return dp[i][j]
        else:
            dp[i][j] = self.paths(i+1,j,m,n, dp) + self.paths(i, j+1, m, n, dp) #calculate path count and store in the dp matrix
            return dp[i][j]  #return the value
        