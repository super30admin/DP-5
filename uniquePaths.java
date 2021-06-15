// RECURSIVE SOLUTION

class Solution {
    public int uniquePaths(int m, int n) {
        return helper(m, n, 0, 0);
    }
    
    private int helper(int m, int n, int i, int j){
        //base 
        if(i == m  || j == n ) return 0;
        if(i == m - 1 && j == n - 1) return 1;
            
        //logic 
        return helper(m, n, i + 1, j) + helper(m, n, i, j + 1);
    }
}
Time Complexity = O(2^mn)
Space Complexity = O(m)

========================================================================================
  
 //. DP APPROACH   USING 2D MATRIX 
  class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int [m + 1][n + 1];
        dp[m - 1][n - 1] = 1;
        
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n -1) continue;
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}

Time Complexity = O(mn)
Space Complexity = O(mn)
  
  
 ========================================================================================
  
 //. DP APPROACH   USING 1D ARRAY
 class Solution {
    public int uniquePaths(int m, int n) {
        if(m < n) return uniquePaths(n, m);
        int dp [] = new int [n];
        int right;
        Arrays.fill(dp, 1);
        
        for(int i = m - 2; i >= 0; i--){
            right = 0;
            for(int j = n - 1; j >= 0; j--){
                dp[j] = dp[j] + right;
                right = dp[j];
            }
        }
        return dp[0];
    }
}

Time Complexity = O(mn)
Space Complexity = O(n)
