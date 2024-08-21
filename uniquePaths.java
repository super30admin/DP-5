/**
 * Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the grid.
 * The algorithm iterates through each cell of the grid exactly once, performing constant-time operations for each cell.

 * Space Complexity: O(n), where n is the number of columns in the grid.
 * The space complexity is determined by the 1D DP array of size n, which is used to store the number of unique paths for the current row.
 */

class Solution {
    public int uniquePaths(int m, int n) {
        // Initialize a 1D array `dp` to store the number of unique paths for the current row
        int[] dp = new int[n];

        // Traverse the grid from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                // If we are at the last row or last column, there is only one way to reach the end (moving straight)
                if (i == m - 1 || j == n - 1)
                    dp[j] = 1;
                else {
                    // Otherwise, the number of unique paths to the current cell is the sum of the paths from the cell to the right (dp[j + 1])
                    // and the current dp[j], which represents the cell below
                    dp[j] = dp[j + 1] + dp[j];
                }
            }
        }

        // The first element of the array `dp[0]` now contains the total number of unique paths from the start to the end
        return dp[0];
    }
}
