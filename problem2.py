# Time Complexity : O(m+n)
# Space Complexity : O(m+n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

class TopDownSolution:
    def uniquePaths(self, m: int, n: int) -> int:
        memo = [[-1] * n for i in range(m)]

        print(memo)
        def recurse(r,c):
            # base
            if r == m or c == n:
                return 0
            if r == m-1 and c == n-1:
                return 1
            # memo check
            if memo[r][c] != -1:
                return memo[r][c]
            # logic
            down = recurse(r+1,c)
            right = recurse(r, c+1)
            memo[r][c] = down + right
            return memo[r][c]
        
        return recurse(0,0)

# Time Complexity : O(m + n)
# Space Complexity : O(m + n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

class BottomUpSolution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0] * n for i in range(m)]

        if m == 1 and n == 1:
            return 1

        for i in range(m):
            dp[i][-1] = 1
        
        for i in range(n):
            dp[-1][i] = 1
        
        dp[-1][-1] = 0

        r,c = m-2, n-2

        for r in range(m-2, -1, -1):
            for c in range(n-2, -1, -1):
                dp[r][c] = dp[r+1][c] + dp[r][c+1]
        
        return dp[0][0]