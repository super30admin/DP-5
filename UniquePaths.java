/* How many possible unique paths are there from top left of matrix to bottom right?
* TC O(N*M) SC O(N*M)
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int [m][n];
        for (int i = 0; i< m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n ; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i< m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
