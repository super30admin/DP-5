import java.util.Arrays;

/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * For each cell (i, j), the number of unique paths is the sum of:
    dp[j] (paths from below)
    dp[j + 1] (paths from the right)
    Instead of using a 2D DP table, we use a single row (dp[]),
    where each element represents the number of paths for the corresponding column.
 */

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0 ; j--) {
                dp[j] = dp[j + 1] + dp[j];
            }
        }

        return dp[0];
    }
    public static void main(String[] args) {
        // Your code here
    }
}