// ******************** Bottom Up Approach ********************

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

// // ******************** Another Method : Top Down 2D array memoization ********************

// // Time Complexity:  O(m*n)
// // Space Complexity: O(m*n)

// class Solution {

//     int m, n;
//     int[][] dp;
    
//     public int uniquePaths(int m, int n) {
//         this.m = m;
//         this.n = n;
//         this.dp = new int[m+1][n+1];
//         return helper(0, 0);
//     }

//     private int helper(int i, int j) {

//         if(i == m || j == n) return 0;
//         if(i == m-1 && j == n-1) return 1;
        
//         dp[i][j+1] = (dp[i][j+1]==0) ? helper(i, j+1) : dp[i][j+1];
//         dp[i+1][j] = (dp[i+1][j]==0) ? helper(i+1, j) : dp[i+1][j];

//         return dp[i][j+1] + dp[i+1][j];

//     }

// }



// // ******************** Another Method : Bottom Up 2D array memoization ********************

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
