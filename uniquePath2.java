//TC: O(MN) iterating through whole matrix

//dp matrix approach
class unique {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0)
            return 0;
        
        //the extra row and col will be 0s so it will help while adding
        int[][] dp = new int[m+1][n+1];
        //the very last cell is set to one because from there we can't go anywhere further
        dp[m - 1][n - 1] = 1;
        
        //we start from the bottom right and move up and left
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                
                //at the very last cell, do nothing and continue
                if(i == m - 1 && j == n - 1)
                    continue;
                
                //no. of ways in which a cell can reach end cell is sum of right and down sum
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        
        return dp[0][0];
    }
    
}