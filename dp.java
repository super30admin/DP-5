//Unique Paths

TC: m*n
SC: m*n

class Solution {
    public int uniquePaths(int m, int n) {
    //The route is limited to either right or down so there's only one possibility 
    //the basic rescursion outcomes :go right or go down -> either keep moving right or keep moving down 
        
        int [][] dp = new int [m][n];
        
        //going right path 
        for(int i = 0 ; i< m ; i++){
            dp[i][0] = 1;
        }
        //going down path 
        for(int j = 0 ; j< m ; j++){
            dp[0][j] = 1;
        }
        
        for(int i=1;i<m ;i++){
            for(int j=1 ; j<n ;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
     return dp[m-1][n-1];
    }
}