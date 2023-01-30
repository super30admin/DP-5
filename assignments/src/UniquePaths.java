// Approach: Initiate a 2d array with first row (0th row) and first column (0th column) with 1
// Here, we fill the whole array with 1 for simplicity.
// Now, go over all the cells starting from index [1][1] and fill them as sum (prevoius left + previous up).
// Finally return the value of bottom-right cell at index [m-1][n-1]
// Time: O(mn)
// Space: O(mn) can be optimized to O(n) as we use previous columns only

import java.util.Arrays;

class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];

        for(int[] arr : d) {
            Arrays.fill(arr, 1);
        }
        for(int col = 1; col < m; ++col) {
            for(int row = 1; row < n; ++row) {
                d[col][row] = d[col - 1][row] + d[col][row - 1];
            }
        }
        return d[m - 1][n - 1];
    }
}