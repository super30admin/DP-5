// //Brute Force-recursion
// //Time = O()
// //space = O()
// class Solution {
//     public int uniquePaths(int m, int n) {
//         return helper(0,0,m,n);
//     }
//     private int helper(int r, int c, int m, int n){
//         //base
//         if(r==m-1 && c==n-1) return 1;
//         if(r==m || c==n) return 0;
//         //logic
//         return helper(r,c+1, m,n)+ helper(r+1,c,m,n);
//     }
// }

//DP-tabulation-bottom up DP
//Time = O(m*n)
//space = O(m*n)
class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        for(int j=0; j<n; j++){
            dp[m-1][j]=1;
        }
        for(int i=0; i<m; i++){
            dp[i][n-1]=1;
        }
        for(int i=m-2; i>=0; i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j]=dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}

// //DP-memoization-top down DP
// //Time = O()
// //space = O()
// class Solution {
//     int [][] memo;
//     public int uniquePaths(int m, int n) {
//         this.memo = new int[m][n];
//         return helper(0,0,m,n);
//     }
//     private int helper(int r, int c, int m, int n){
//         //base
//         if(r==m-1 && c==n-1) return 1;
//         if(r==m || c==n) return 0;
//         if(memo[r][c]!=0) return memo[r][c];
//         //logic
//         int result = helper(r,c+1, m,n)+ helper(r+1,c,m,n);
//         memo[r][c]=result;
//         return result;
//     }
// }