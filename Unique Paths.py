#  using dp 
# time o(mn), where m, n is number of rows and columns respectively
# space o(n), where m, n is number of rows and columns respectively
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
#         memoization
#         time complexity is o(mn), where m, n is number of rows and columns respectively
#  space is o(mn), where m, n is number of rows and columns respectively
        self.memo = [[0 for i in range(n+1)] for i in range(m+1)] #space is o(mn)
        return self.helper(0, 0, m, n)
    
    def helper(self, i, j, m, n):
        if(i == m or j == n):
            return 0
        if(i == m-1 and j == n-1):
            return 1
        right = 0
        if(self.memo[i][j+1] == 0):
            self.memo[i][j+1] = self.helper(i, j+1, m, n)
        right = self.memo[i][j+1]
        bottom = 0
        if(self.memo[i+1][j] == 0):
            self.memo[i+1][j] =  self.helper(i+1, j, m, n)
        bottom = self.memo[i+1][j]
        return right + bottom
    
        
        
        
#         Recursive
#         return self.helper(0, 0, m, n)
    
#     def helper(self, i, j, m, n):
#         if(i == m or j == n):
#             return 0
#         if(i == m-1 and j == n-1):
#             return 1
        
#         right = self.helper(i, j+1, m, n)
#         bottom =  self.helper(i+1, j, m, n)
#         return right + bottom
    
        
#         using DP       
#         time o(mn)
#         space o(n)
        # dp = [0 for i in range(n+1)] # space o(n)
        # dp[1] = 1
        # for i in range(1, m+1): # time o(mn)
        #     for j in range(1, n+1):
        #         dp[j] = dp[j-1] + dp[j]
        # return dp[n]
        
#  time o(mn)
#  space o(mn)
#         dp = [[0 for i in range(n+1)] for i in range(m+1)] #space o(mn)
#         dp[1][1] = 1
#         for i in range(1, m+1): # time o(mn)
#             for j in range(1, n+1):
#                 if(i == 1 and j == 1):
#                     continue
#                 dp[i][j] = dp[i-1][j] + dp[i][j-1]
#         return dp[m][n]
    
    
        
        
        # def check(m,n, memo):
        #     key = str(m) +','+str(n)
        #     if(key in memo):
        #         return memo[key]
        #     if(m == 1 and n == 1):
        #         return 1
        #     if(m == 0 or n == 0):
        #         return 0
        #     memo[key] = check(m-1, n, memo) + check(m, n-1, memo)
        #     return memo[key]
        # return check(m,n,{})
        
#         row = [1]* n
        
#         for i in range(m-1):
#             newRow = [1]*n
#             for j in range(n-2,-1,-1):
#                 newRow[j] = row[j] + newRow[j+1]
#             row = newRow
#         return row[0]


#         import math
#         m = m - 1
#         n = n - 1
        
#         num = math.factorial(m+n)
#         den = math.factorial(m) * math.factorial(n)
#         res = num // den
#         return res