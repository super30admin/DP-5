// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class UniquePaths {
    class Solution {
        public int uniquePaths(int m, int n) {

            int[][] dp = new int[m][n];

            for(int[] arr : dp) {
                Arrays.fill(arr, 1);
            }

            for(int i=1; i<m; i++) {
                for(int j=1; j<n; j++) {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }

            return dp[m-1][n-1];
        }
    }
}
