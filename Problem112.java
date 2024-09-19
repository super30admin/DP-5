//Time: O(m * n)
//Space: O(m * n)
class Solution {
    public int uniquePaths(int m, int n) {
        // Create a 2D array dp with m rows and n columns
        int[][] dp = new int[m][n];
        
        // Initialize the first row and first column with 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;  // Only one way to move down in the first column
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;  // Only one way to move right in the first row
        }
        
        // Fill the dp array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];  // Sum of the ways from the top and the left
            }
        }
        
        // The answer is the number of ways to reach the bottom-right corner
        return dp[m-1][n-1];
    }
}
