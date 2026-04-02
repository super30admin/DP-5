// Recursive TLE O(2^m+n) time, O(m+n) space
// class Solution {
//     public int uniquePaths(int m, int n) {
//         return helper(0, m, 0, n);
//     }

//     private int helper(int i, int m, int j, int n) {
//         if (i >= m || j >= n) {
//             return 0;
//         }

//         if (i == m-1 && j == n-1) {
//             return 1;
//         }

//         int right = helper(i, m, j+1, n);
//         int down = helper(i+1, m, j, n);
        
//         return right + down;
//     }
// }

// Memoization O(m * n) time, O(m * n) space
// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return helper(0, m, 0, n, dp);
//     }

//     private int helper(int i, int m, int j, int n, int[][] dp) {
//         if (i >= m || j >= n) {
//             return 0;
//         }

//         if (i == m-1 && j == n-1) {
//             return 1;
//         }

//         if (dp[i][j] != -1) return dp[i][j];

//         int right = helper(i, m, j+1, n, dp);
//         int down = helper(i+1, m, j, n, dp);
        
//         dp[i][j] = right + down;
        
//         return dp[i][j];
//     }
// }

// Bottom up O(m * n) time, O(m * n) space
// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (i == 0 || j == 0) {
//                     dp[i][j] = 1;
//                 } 
//                 else {
//                     int top = dp[i-1][j]; 
//                     int left = dp[i][j-1];
//                     dp[i][j] = top + left;
//                 }
//             }
//         }
//         return dp[m-1][n-1];
//     }
// }

// Bottom up space optimized O(m * n) time, O(n) space
class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        int[] curr = new int[n];

        for (int j = 0; j < n; j++) {
            prev[j] = 1; // 1st row all 1s
        }

        for (int i = 0; i < m; i++) {
            curr[0] = 1; // 1st col all 1s
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    curr[j] = 1;
                } else {
                    int top = prev[j]; 
                    int left = curr[j-1];
                    curr[j] = top + left;
                }
            }
            prev = curr.clone();
        }
        return prev[n-1];
    }
}