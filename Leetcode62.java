// Solution 1: DP with 1D array
// TC - O(m*n) - iterate over matrix once.
// SC - O(n) - DP array space.
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                dp[i] = dp[i] + dp[i - 1];
            }
        }
        return dp[n - 1];
    }
}

// Solution 2: DP with 2D array
// TC - O(m*n) - iterate over matrix once.
// SC - O(m*n) - DP array space.
// class Solution {
// public int uniquePaths(int m, int n) {
// int[][] dp = new int[m][n];
// for(int i =0; i < m; i++) {
// dp[i][0] = 1;
// }
// for(int i =0; i < n; i++) {
// dp[0][i] = 1;
// }
// for(int i =1; i <m; i++) {
// for(int j=1; j<n; j++){
// dp[i][j] = dp[i-1][j] + dp[i][j-1];
// }
// }
// return dp[m-1][n-1];
// }
// }