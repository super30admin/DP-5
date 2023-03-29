#Time Complexity :- O(mn)
#Space Complexity :- O(mn)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = []

        for i in range(m+1):
            col = []
            for j in range(n+1):
                col.append(0)
            dp.append(col)
        dp[m-1][n-1] = 1

        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                if i == m-1 and j == n-1:
                    continue
                dp[i][j] = dp[i+1][j] + dp[i][j+1]
        return dp[0][0]


#Time Complexity :- O(mn)
#Space Complexity :- O(n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = []

        for i in range(n):
            dp.append(1)       

        for i in range(m-2, -1, -1):
            for j in range(n-2, -1, -1):
                dp[j] = dp[j+1] + dp[j]
        return dp[0]



#Time Complexity :- O(exponential)
#Space Complexity :- O(mn)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.helper(m, n, 0, 0)
    
    def helper(self, m, n, r, c):
        # base
        if (r == m or c == n):
            return 0
        
        if r == m - 1 and c == n - 1:
            return 1

        #logic
        right = self.helper(m, n, r, c+1)
        bottom = self.helper(m, n, r+1, c)

        return right + bottom


        


        