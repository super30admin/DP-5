
# class Solution:
#     def uniquePaths(self, m: int, n: int) -> int:

#         def helper(r,c,m,n):
#             # base
#             if r == m-1 and c == n-1: return 1
#             if r == m or c == n : return 0

#             # logic
#             return helper(r+1,c,m,n) + helper(r,c+1,m,n)

#         return helper(0,0,m,n)

# class Solution:
#     def uniquePaths(self, m: int, n: int) -> int:
#         dp = [[0 for j in range(n)] for i in range(m)]
#         for i in range(m):
#             dp[i][n-1] = 1
#         for j in range(n):
#             dp[m-1][j] = 1
#         for i in range(m-2, -1,-1):
#             for j in range(n-2,-1,-1):
#                 dp[i][j] = dp[i+1][j] + dp[i][j+1]
#         return dp[0][0]
        
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [1]*n
        for i in range(m-2, -1,-1):
            for j in range(n-2,-1,-1):
                dp[j] = dp[j] + dp[j+1]
        return dp[0]


# class Solution:
#     def uniquePaths(self, m: int, n: int) -> int:
#         memo = [[0 for j in range(n+1)] for i in range(m+1)]
#         def helper(r,c,m,n):
#             # base
#             if r == m-1 and c == n-1: return 1
#             if r == m or c == n : return 0
#             if memo[r][c]!=0: return memo[r][c]

#             # logic
#             memo[r][c]=helper(r+1,c,m,n) + helper(r,c+1,m,n)
#             return memo[r][c]

#         return helper(0,0,m,n)
        
        