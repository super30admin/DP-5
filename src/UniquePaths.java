// Time Complexity:  O(m*n)
// Space Complexity: O(n)

class Solution {

    int[] dp;
    
    public int uniquePaths(int m, int n) {

        dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }

        return dp[n-1];
    }

}



// // ******************** Another Method : 2D array memoization ********************

// // Time Complexity:  O(m*n)
// // Space Complexity: O(m*n)

// class Solution {

//     int[][] dp;
    
//     public int uniquePaths(int m, int n) {

//         if(m == n && m == 1) {
//             return 1;
//         }

//         dp = new int[m][n];
//         for(int i=1; i<m; i++) {
//             dp[i][0] = 1;
//         }
//         for(int j=1; j<n; j++) {
//             dp[0][j] = 1;
//         }
//         for(int i=1; i<m; i++) {
//             for(int j=1; j<n; j++) {
//                 dp[i][j] = dp[i-1][j] + dp[i][j-1];
//             }
//         }

//         return dp[m-1][n-1];
//     }

// }
