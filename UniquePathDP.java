package Dec8;

class UniquePathDP {
	
    public int uniquePaths(int m, int n) {
        /*
        Time complexity: O(mn) 
    
        Approach: DP approach.
        */
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                // to handle the dp array element at m,n position ,
            	// i.e. bottom right element in the array should be 1 always 
            	// and not equal to dp[i+1][j] + dp[i][j+1] 
            	// or else it will become 0+0 = 0 which is incorrect.
                if (i == m - 1 && j == n-1) {
                    
                } else {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        
        return dp[0][0];
    }
}