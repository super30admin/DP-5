//Time  - O(n^2) where n is the length of the string
//Space - O(n^2)  
// Leetcode - worked


class Solution {
    public int uniquePaths(int m, int n) {
        if(m==0 && n == 0) return 1;
        
        int[][] dp = new int[m+1][n+1];
        
        
        for(int i=m-1; i>=0 ; i--){
            for(int j=n-1; j>=0 ; j--){
                if(i == m-1 && j == n-1){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
                System.out.println(dp[i][j]);
                
            }
        }
        
        return dp[0][0];
    }
}