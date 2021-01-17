/*
 * TC: O(M * N)
 * SC: O(M * N)
 * LeetCode: Y(https://leetcode.com/problems/unique-paths/)
 * Approach: 
    The number of ways to reach (m, n) from mth row and nth column is 1
    Number of ways to reach (m , n) from (i, j) = Number of ways to reach (m , n) from (i + 1, j) +
                                                  Number of ways to reach (m , n) from (i, j + 1)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        
        // Initialize dp matrix
        int[][] dp = new int[m + 1][n + 1];
        
        // Set destination point to 1
        dp[m - 1][n - 1] = 1;
        
        // Fill the dp matrix
        for(int i = m - 1 ; i >= 0 ; i--) {
            for(int j = n - 1 ; j >= 0 ; j--) {
                if(i == m - 1 && j == n - 1) {
                    continue;
                }
                // Number of ways to reach (m , n) from (i, j) = Number of ways to reach (m , n) from (i + 1, j) +
                //                                               Number of ways to reach (m , n) from (i, j + 1)
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
                
                
            }
        }
        
        // return the number of ways to reach (m, n) from (0, 0)
        return dp[0][0];
    }
}
