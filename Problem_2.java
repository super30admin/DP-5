// Time Complexity : O(m*n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// start from the bottom of the array, add the left and down value ( in 1d it will be the same value) then retuen the (0,0) of the array or the 1st value of the array
// Your code here along with comments explaining your approach

// reduce the space of dp array,
class Solution {
    public int uniquePaths(int m, int n) {
        int [] dp = new int [n+1];
        Arrays.fill(dp, 1);
        dp[n] = 0;
        for(int i = m-2; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                dp[j] = dp[j] + dp[j+1];
            }
        }
        return dp[0];
    }
}

// // using 2d dp matrix
// class Solution {
//     public int uniquePaths(int m, int n) {
//         int [][] dp = new int [m+1][n+1];
//         dp[m-1][n-1] = 1;
//         for( int i = m-1; i >= 0; i--){
//             for( int j = n-1; j >= 0; j--){
//                 if(i == m-1 && j == n-1) continue;
//                 dp[i][j] = dp[i+1][j] + dp[i][j+1];
//             }
//         }
//         return dp[0][0];
//     }
// }

// using recursion and memoization
// class Solution {
//     int [][] table;
//     public int uniquePaths(int m, int n) {
//         table = new int[m+1][n+1];
//         return dp(m,n,0,0);
//     }
//     private int dp(int m, int n, int i, int j){
//         // base
//         if( i >= m || j >= n) return 0;
//         if(i == m-1 && j == n-1) return 1;
//         // logic
//         // right
//         if(j < n-1 && table[i][j+1] == 0){
//             table[i][j+1] = dp( m, n, i, j+1);
//         }
//         int right = table[i][j+1];
//         // down
//         if( i < m-1 && table[i+1][j] == 0){
//             table[i+1][j] = dp( m, n, i+1, j);
//         }
//         int left = table[i+1][j];
//         return right + left;
//     }
// }