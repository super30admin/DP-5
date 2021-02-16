/* brute force 
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.dfs(m, n, 0, 0)
    
    def dfs(self, m, n, start_i, start_j):
        # base
        if start_i == m-1 and start_j == n-1:
            return 1
        
        if start_i > m -1 or start_j > n-1:
            return 0
        
        # logic 
        right = self.dfs(m, n, start_i, start_j+1)
        down = self.dfs(m, n, start_i+1, start_j)
        
        return right + down

class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(m, n, 0, 0);
    }
    
    private int dfs(int m, int n, int start_i, int start_j){
        if (start_i == m-1 && start_j == n-1)
            return 1;
        
        if (start_i > m-1 || start_j > n-1)
            return 0;
        
        int right = dfs(m, n, start_i, start_j+1);
        int down = dfs(m, n, start_i+1, start_j);
        
        return right + down;
    }
}

*/

/*
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        
        dp = [[0 for _ in range(n+1)] for i in range(m+1)]
        dp[m-1][n-1] = 1
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                if i == m-1 and j == n-1:
                    continue
                dp[i][j] = dp[i+1][j] + dp[i][j+1]
        
        return dp[0][0]

// space - O(n)
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        
        for (int i=0; i<m; i++){
            for (int j=1; j<n; j++){
                
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }
    
}
*/

// time - O(m*n)
// space - O(m*n)
// Logic - started with target index and then everytime check for right and down path
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        
        for (int i=m-1; i>=0; i--){
            for (int j=n-1; j>=0; j--){
                if (i == m-1 && j == n-1) continue;
                
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
    
}
        