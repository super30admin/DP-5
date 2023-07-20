// Normal recursion without top down dp(memoization - dp using memo matrix) or bottom up dp(dp using dp matrix) 
// class Solution {
//     public int uniquePaths(int m, int n) {
//         // robot can go right and down at every point
//         return helper(0,0,m,n);
//     }
//     public int helper(int i, int j, int m, int n){
//         // base
//         if(i==m-1 && j==n-1) return 1; //robot reaches the destination
//         if(i==m || j==n) return 0; //robot hits the boundaries hence can't go right or down accordingly hence return 0
//         // logic
//         // go right
//         int case1 = helper(i,j+1,m,n);
//         // go down
//         int case2 = helper(i+1,j,m,n);

//         return case1 + case2;
//     }
// }

// Top Down DP - Memoization -- O(mn)
// class Solution {
//     int[][] memo;
//     public int uniquePaths(int m, int n) {
//         memo = new int[m][n];
//         // robot can go right and down at every point
//         return helper(0,0,m,n);
//     }
//     public int helper(int i, int j, int m, int n){
//         // base
//         if(i==m-1 && j==n-1) return 1; //robot reaches the destination
//         if(i==m || j==n) return 0; //robot hits the boundaries hence can't go right or down accordingly hence return 0
//         // logic
//         // go right
//         int case1 = 0;
//         if(j<n-1){
//             if(memo[i][j+1]!=0){ // that means I have a previously stored value
//                 case1 = memo[i][j+1];
//             }else{
//                 memo[i][j+1] = helper(i,j+1,m,n);
//                 case1 = memo[i][j+1];
//             }
//         } 
            
        
//         // go down
//         int case2 = 0;
//         if(i<m-1){
//             if(memo[i+1][j]!=0){ // that means I have a previously stored value
//                 case2 = memo[i+1][j];
//             }else{
//                 memo[i+1][j] = helper(i+1,j,m,n);
//                 case2 = memo[i+1][j];
//             }
//         } 

//         return case1 + case2;
//     }
// }

// Bottom Up DP -- O(mn)
class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        // Fill last row with 1 -as we have only one option to reach the destination
        for(int j=0;j<n;j++){
            dp[m-1][j] = 1;
        }

        // Fill last column with 1 -as we have only one option to reach the destination
        for(int i=0;i<m;i++){
            dp[i][n-1] = 1;
        }
        // Start iterating from second last row and second last column
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j] = dp[i][j+1] + dp[i+1][j]; // addition of value towards right and value downwards

            }
        }

        return dp[0][0]; //As we are going from bottom to top
    }
    
}