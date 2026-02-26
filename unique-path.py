#-------------- Solution 1 : recursive : Time limit exceed----------
''' Time Complexity :  O(2^m+n)
    Space Complexity : O(m+n)

'''
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:

        def helper(i,j, m, n):
            if i == m or j == n :
                return 0
            if i == m-1 and j == n-1:
                return 1

            right = helper(i, j+1, m, n)
            down = helper(i+1, j, m, n)
            return right + down
        
        return helper(0,0,m,n)

#-------------- Solution 2 : recursive with memoization----------
''' Time Complexity :  O(m*n)
    Space Complexity : O(m*n)

'''
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        memo = [[0 for _ in range(n)] for _ in range(m)]
        print(memo)
        def helper(i,j, m, n):
            if i == m or j == n :
                return 0
            if i == m-1 and j == n-1:
                return 1
            if memo[i][j] != 0:
                return memo[i][j] 

            right = helper(i, j+1, m, n)
            down = helper(i+1, j, m, n)
            memo[i][j] = right+down
            return right + down
        
        return helper(0,0,m,n)
            

#-------------- Solution 3 : DP 2D array----------
''' Time Complexity :  O(m*n)
    Space Complexity : O(m*n)

'''
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0 for _ in range(n)] for _ in range(m)]
        for i in range(m):
            dp[i][0] = 1
        for j in range(n):
            dp[0][j] = 1
        for i in range(1,m):
            for j in range(1,n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        
        return dp[m-1][n-1]

#-------------- Solution 4 : DP 1D array----------
''' Time Complexity :  O(m*n)
    Space Complexity : O(n)

'''
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [1 for _ in range(n)]
        for i in range(1,m):
            for j in range(1,n):
                dp[j] = dp[j] + dp[j-1]
 
        return dp[n-1]