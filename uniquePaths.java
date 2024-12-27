// Time Complexity : 1 - O(2^m+n) 2,3 - O(mn)
// Space Complexity : 1 - O(m+n), 2 - O(mn), 3 - O(n)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach
// Case 1 - Recursion
// class Solution {
//     public int uniquePaths(int m, int n) {
//         if(m == 0 && n == 0) return 0;
//         return recurse(m,n,0,0);
//     }

//     private int recurse(int m, int n, int row, int col) {
//         // base
//         if(row == m || col == n) return 0;
//         if(row == m-1 && col == n-1) return 1;
//         // logic
//         int case1 = recurse(m, n, row+1, col);
//         int case2 = recurse(m, n, row, col+1);
//         return case1 + case2;
//     }
// }

// Case 2 - 2D matrix DP
// class Solution {
//     public int uniquePaths(int m, int n) {
//         if(m == 0 && n == 0) return 0;
//         int[][] dp = new int[m+1][n+1];
//         dp[m][n-1] = 1;
//         for(int i = m-1; i>=0; i--) {
//             for(int j = n-1; j>=0; j--) {
//                 dp[i][j] = dp[i+1][j] + dp[i][j+1];
//             }
//         }
//         return dp[0][0];
//     }
// }

// Case 3 - 1D matrix DP
class Solution {
  public int uniquePaths(int m, int n) {
    if(m == 0 && n == 0) return 0;
    int[] dp = new int[n];
    Arrays.fill(dp,1);
    for(int i = m-2; i>=0; i--) {
      for(int j = n-2; j>=0; j--) {
        dp[j] = dp[j] + dp[j+1];
      }
    }
    return dp[0];
  }
}