//time - O(m*n)
//space - O(m*n)
class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        return helper(0,0,m,n);
    }
    
    private int helper(int i, int j, int m , int n){
        if( i == m-1 && j == n-1)return 1;
        if(i==m || j ==n) return 0;
        if(dp[i+1][j] ==0){
            dp[i+1][j] = helper(i+1, j, m, n);
        } 
        int bottom = dp[i+1][j];
        if(dp[i][j+1] ==0){
            dp[i][j+1] = helper(i, j+1, m,n);
        }
        int right = dp[i][j+1];
        return right+bottom;
    }
}