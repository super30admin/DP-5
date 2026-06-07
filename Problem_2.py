# class Solution:
#     def uniquePaths(self, m, n):
#         return self.helper(0, 0, m, n)

#     def helper(self, cr, cc, dr, dc):
#         if cr >= dr or cc >= dc:
#             return 0
#         if cr == dr - 1 and cc == dc - 1:
#             return 1

#         down = self.helper(cr + 1, cc, dr, dc)
#         right = self.helper(cr, cc + 1, dr, dc)

#         return down + right

# class Solution:
#     def uniquePaths(self, m,n):
#         memo = [[-1] * n for _ in range(m)]
#         return self.helper(0, 0, m, n, memo)

#     def helper(self, cr, cc, dr, dc, memo):
#         if cr >= dr or cc >= dc:
#             return 0
#         if cr == dr - 1 and cc == dc - 1:
#             return 1
#         if memo[cr][cc] != -1:
#             return memo[cr][cc]
#         down = self.helper(cr + 1, cc, dr, dc, memo)
#         right = self.helper(cr, cc + 1, dr, dc, memo)
#         memo[cr][cc] = down + right
#         return memo[cr][cc]

# class Solution:
#     def uniquePaths(self, m,n):
#         memo = [[1] * (n) for _ in range(m)]
#         for cr in range(1, m):
#             for cc in range(1, n):
#                 up = memo[cr - 1][cc]
#                 left = memo[cr][cc - 1]
#                 memo[cr][cc] = up + left
#         return memo[m - 1][n - 1]
    

class Solution:
    def uniquePaths(self, m,n):
        memo = [1] * (n)
        for _ in range(1, m):
            for cc in range(1, n):
                up = memo[cc]
                left = memo[cc - 1]
                memo[cc] = up + left
        return memo[n - 1]
