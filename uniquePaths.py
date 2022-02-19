class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        '''
        Bottom Up approach 
        Time Complexity = O(M*N)
        Space Complexity = O(N)
        '''
        if m== 0 and n == 0 : return 0 
        dp = [ 1 for x in range(n) ]
        for i in range(m-2, -1 , -1):
            for j in range(n-2, -1 , -1):
                dp[j] = dp[j+1] + dp[j]
        return dp[0]
        
    def TopDownuniquePaths(self, m: int, n: int) -> int:
        '''
        Top down approach 
        Time Complexity = O(M*N)
        Space Complexity = O(M*N)
        '''
        def dp_dfs(i, j , m , n):
            
	        if i ==m or j == n: return 0 
	        if dp[i][j] != 0 : return dp[i][j]
            
	        dp[i][j] = dp_dfs(i+1, j, m ,n) + dp_dfs(i,j+1,m,n)
	        return dp[i][j] 
        
        dp = [ [0]*n for x in range(m)  ]
        dp[m-1][n-1] = 1
        dp_dfs(0,0,m,n)
        return dp[0][0]
      
    def bruteForceuniquePaths(self, m: int, n: int) -> int:
        '''
        Time Complexity = Exponential 
        Space Complexity = 0(1)
        '''
        def dfs( i , j , m , n  ):
            #base condition 
            if i == m or j == n:
                return 0 
            # when the path reaches the destination, (m-1,n-1)
            if i == m-1 and j == n-1:
                return 1
            # logic - you can traverse either right or down 
            return dfs( i , j+1 , m , n ) + dfs( i+1 , j , m, n )
        
        if m == 0 or n == 0 :
            return 0
        return dfs( 0 , 0 , m , n )
    
    
    
    
