// TC: O(m * n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // Recusrsive, TC = O(exponential), SC = O(m + n) rec stack space, not m*n as see how the rec calls are made, m + n
    // public int uniquePaths(int m, int n) {
    //     if(m == 0 && n == 0) return 0;
    //     return recurse(m, n, 0, 0);
    // }
    // private int recurse(int m, int n, int i, int j) {
    //     // base
    //     if(i == m || j == n) return 0;
    //     if(i == m - 1 && j == n - 1) return 1;
    //     // logic
    //     // right
    //     int case1 = recurse(m, n, i, j + 1);
    //     // down
    //     int case2 = recurse(m, n, i + 1, j);
    //     return case1 + case2;
    // }

    // DP, at each cell, calculate the no of ways from right + left, have dummy row so that we dont have to change the logic & dp[m - 1][n - 1] is initialized as 1
    // TC = O(m * n), SC = O(m * n)
    // public int uniquePaths(int m, int n) {
    //     if(m == 0 && n == 0) return 0;
    //     int[][] dp = new int[m + 1][n + 1]; // for accomodating dummy row
    //     dp[m - 1][n - 1] = 1; // as there will be always 1 way in this cell
    //     for(int i = m - 1; i >= 0; i--) {
    //         for(int j = n - 1; j >= 0; j--) {
    //             if(i == m - 1 && j == n - 1) continue; // dont overwrite the initialized value
    //             else dp[i][j] = dp[i][j + 1] + dp[i + 1][j]; // left + down
    //         }
    //     }
    //     return dp[0][0]; // answer is in the 1st cell as all are summing up there
    // }

// Optimized DP, as we need only 2 values (R & D), we can use an array, initialize it with 1 & 
    // TC = O(m * n), SC = O(n)
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // corresponds to the last row of dp[m - 1][n]
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                dp[j] = dp[j + 1] + dp[j]; // left + down
            }
        }
        return dp[0];
    }
}