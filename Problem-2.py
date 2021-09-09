class Solution:
    # Approach 1: DFS
    """
    TC: O(2^(m*n))
    Exceeds time limit
    """
    def uniquePaths(self, m: int, n: int) -> int:
        self.count = 0
        self.dfs(0,0,m,n)
        return self.count
    
    def dfs(self, r,c, m, n ):
        #base
        if not 0<= r < m or not 0<= c < n:
            return
        if r == m-1 and c == n-1:
            self.count += 1
        
        #logic
        self.dfs(r + 1, c, m, n)
        self.dfs(r, c+1, m, n)
    
    # Approach 2: DP
    """
    TC: O(m*n)
    SC: O(m*n)
    """
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0]*n for _ in range(m)]
        for r in range(m-1, -1, -1):
            dp[r][n-1] = 1
        
        for c in range(n-1, -1, -1):
            dp[m-1][c] = 1
        
        for r in range(m-2, -1, -1):
            for c in range(n-2, -1, -1):
                dp[r][c] = dp[r][c+1] + dp[r+1][c]
        
        return dp[0][0]
    
    # Approach 3: Space optimized DP
    """
    TC: O(m*n)
    SC: O(n)
    """
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [1]*n
        
        for r in range(m-2, -1, -1):
            for c in range(n-2, -1, -1):
                dp[c] += dp[c+1]
        
        return dp[0]
    
    # Approach 4: #combinatorics
    from math import factorial
    def uniquePaths(self, m: int, n: int) -> int:
        fn = m+n-2
        fk = n-1
        return int(factorial(fn)/(factorial(fk)*(factorial(fn-fk))))