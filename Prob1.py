class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        #Method 1 - Brute Force Int based recursion - TLE - TC O(2^mn)
        # def helper(i,j,m,n):
        #     #base
        #     if i==m-1 and j==n-1: return 1 #bottom right reached return 1 
        #     if i==m or j==n: return 0 #out of bounds return 0

        #     #logic
        #     case1=helper(i+1,j,m,n) #recursively go right and left at each point till either yuou reach bottom right or go out of bounds. 
        #     case2=helper(i,j+1,m,n)
        #     return case1+case2
        # return helper(0,0,m,n)

        #Method1 - Brute Force Void based recursion - TLE - TC O(2^mn)
        # def helper(i,j,m,n):
        #     nonlocal res
        #     #base
        #     if i==m-1 and j==n-1: 
        #         res+=1
        #         return #bottom right reached increase res by 1 
        #     if i==m or j==n: 
        #         return #just return

        #     #logic
        #     helper(i+1,j,m,n) #recursively go right and left at each point till either yuou reach bottom right or go out of bounds. 
        #     helper(i,j+1,m,n)
        # res=0
        # helper(0,0,m,n)
        # return res

        #Method 2 - Bottom-up DP 2D array - TC and SC O(mn)
        # dp = [[0 for _ in range(n)] for _ in range(m)]

        # # Set the last row to 1s
        # for j in range(n):
        #     dp[m-1][j] = 1
        
        # # Set the last column to 1s
        # for i in range(m):
        #     dp[i][n-1] = 1

        # for i in range(m-2, -1, -1): #you start from left of bottom right, go till left top so -1, and go in reverse so -1
        #     for j in range(n-2, -1, -1): #you start from top of bottom right, go till left top so -1, and go in reverse so -1
        #         dp[i][j] = dp[i+1][j] + dp[i][j+1]
        
        # return dp[0][0]
        #Method 3 - Bottom-up DP 1D array - TC and SC O(n)
        # dp = [0] * n
        # dp[n - 1] = 1
        
        # for i in range(m - 1, -1, -1):
        #     for j in range(n - 2, -1, -1):
        #         dp[j] = dp[j] + dp[j + 1]
        #         print(dp)
        
        # return dp[0]

        #Method 4 - Top-Down 2D array - TC and SC O(mn)
        memo=[[0 for _ in range(n+1)] for _ in range(m+1)] #added aditional row and col
        def helper(i,j,m,n):
            #base
            if i==m-1 and j==n-1: return 1 #bottom right reached return 1 
            if i==m or j==n: return 0 #out of bounds return 0

            #logic
            if memo[i][j+1]==0: #if right is not found, find it
                memo[i][j+1]=helper(i,j+1,m,n)
            case1=memo[i][j+1]   #then in the end if newly found or already exists, assign to case1
            if memo[i+1][j]==0: #if bottom is not found, find it
                memo[i+1][j]=helper(i+1,j,m,n)
            case2=memo[i+1][j] #then in the end if newly found or already exists, assign to case2
            return case1+case2 
        return helper(0,0,m,n)


        
    

    