/**
 * Time complexity: O(m*n)
 * Space complexity: O(m*n)
 * 
 * Approach:
 * 1. store the the paths till we reach to the (m-1, n-1) block.
 * 2. proceed to the target block, based on the paths till the previous blocks.
 */

class uniquePaths1 {
    public int uniquePaths(int m, int n) {
        
        if( m == 0 && n == 0)
            return 0;
        
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0|| j==0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
        // return helper(m, n, 1, 1);
    }
    
    private int helper(int m, int n, int m1, int n1) {
        //base
        if(m1 > m || n1 > n)
            return 0;
        
        //logic
        if(m == m1 && n == n1)
            return 1;
        
        return helper(m, n, m1+1, n1) + helper(m, n, m1, n1+1);
    }
} 