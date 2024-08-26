//Time = O(m x n), m and n are the dimensions of the input grid
//Space = O(m x n)

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; // Initialize a 2D integer array of size m x n to store intermediate results

        // Initialize the first row and first column of the dp array to 1 since there is only 1 way to reach any cell in the first row or first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Loop through each cell of the dp array, starting from the second row and second column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; // The number of ways to reach the current cell is equal to the sum of the number of ways to reach the cell above it and the cell to the left of it
            }
        }

        return dp[m-1][n-1]; // The number of ways to reach the bottom-right cell is stored in dp[m-1][n-1]
    }
}
