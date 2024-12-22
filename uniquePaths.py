# Time:O(m*n) 
# Space:O(m*n) for dp; O(m) for array dp
# Leetcode: Yes
# Issues: No


# Memoisation iteration(reverse)
class Solution:

    def uniquePaths(self, m: int, n: int) -> int:

        dp = [[0] * (n+1) for i in range(m+1)]              # extra column and row
        dp[m-1][n-1] = 1                                    # remove extra step

        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if i == m-1 and j == n-1:
                    continue
                dp[i][j] = dp[i][j+1]+ dp[i+1][j]           # Memoisation
        return dp[0][0]

# Iteration (Reverse) same as above
class Solution:

    def uniquePaths(self, m: int, n: int) -> int:

        dp = [[0] * n for i in range(m)]                    # m*n dp

        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if i==m-1 or j == n-1:
                    dp[i][j] = 1                        
                else:
                    dp[i][j] = dp[i][j+1]+ dp[i+1][j]       # Memoisation
                    
        return dp[0][0]

# standard iteration 
class Solution:

    def uniquePaths(self, m: int, n: int) -> int:

        dp = [[0] * n for i in range(m)]

        for i in range(m):
            for j in range(n):
                if i==0 or j == 0:
                    dp[i][j] = 1
                else:
                    dp[i][j] = dp[i-1][j]+ dp[i][j-1]
                    
        return dp[-1][-1]
    
# recursive memoisation
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:

        memo = [[0] * n for i in range(m)]

        def helper(m,n,i,j):
            nonlocal memo
            #basecase
            if i==m-1 and j==n-1:
                return 1

            if i >= m or j >= n:
                return 0
            
            if memo[i][j] != 0:
                return memo[i][j]

            #logic
            case0 = helper(m,n,i,j+1)
            case1 = helper(m,n,i+1,j)
            
            memo[i][j] = case0 + case1
            return memo[i][j]

        return helper(m,n,0,0)


# array dp Space: O(n)
class Solution:

    def uniquePaths(self, m: int, n: int) -> int:

        dp = [1] * n                        

        for i in range(1, m):
            for j in range(1, n):
                dp[j] += dp[j-1]
        return dp[-1]
    