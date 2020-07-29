//62. Unique Paths.java
//Time:O(m*n)
//Space:O(m*n)


class Solution {
    public int uniquePaths(int m, int n) {
        //dp array
        int[][] dp = new int[m][n];
        
        //initialize dp array
        
        dp[0][0] = 1;
        for(int i = 0; i < m; ++i){
            
            for(int j = 0; j < n; ++j){
                
                if(i == 0 && j == 0)
                    continue;
                int left = 0;
                int up = 0;
                if( i-1 >= 0 ){
                    left = dp[i-1][j];
                }
            
                if( j-1 >= 0 ){
                    up = dp[i][j-1];
                }
            dp[i][j] = left + up;
        }

    }
        return dp[m-1][n-1];
}
}
