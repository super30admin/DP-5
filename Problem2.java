class Solution {
   //TC: O(m*n)
   //SC: O(m*n)
    public int uniquePaths(int m, int n) {
       int [][] dp = new int[m][n];
       dp[m-1][n-1] = 1;
       if(m == 1 || n == 1) return 1;
       for(int i = m-2; i >= 0; i--){
           for(int j = n-2; j >=0; j--){
               int right = 1;
               int down  = 1;
               if(i != m-2){
                   down = dp[i+1][j];
               }
               if(j != n-2){
                   right = dp[i][j+1];
               }
               dp[i][j] = right + down;
           }
       }
       return dp[0][0];
    }
    
}
