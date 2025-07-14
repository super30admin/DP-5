import java.util.Arrays;

//Time comeplexity: O(m * n)
//Space complexity: O(m * n)
//Intuition: We can use dynamic programming to solve this problem. 
// Take from the top-left corner of the grid and move to the bottom-right corner.
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] d = new int[m][n];

        for (int[] arr : d) {
            Arrays.fill(arr, 1);
        }
        for (int col = 1; col < m; col++) {
            for (int row = 1; row < n; row++) {
                d[col][row] = d[col - 1][row] + d[col][row - 1];
            }
        }
        return d[m - 1][n - 1];
    }
}
