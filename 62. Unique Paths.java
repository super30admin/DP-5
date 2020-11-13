class Solution {// time and space of O(MN)
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n] ;
        
        //filling the first row with 1
        for(int i = 0; i < n ; i++){
            dp[0][i] = 1;
        }
        //filling first column 
        for(int j = 1 ; j< m ;j++){
            dp[j][0] = 1 ;
        }
        //dp making decision based on previous result;
        for(int i= 1 ; i<m ; i++){
            for(int j = 1; j< n ; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}