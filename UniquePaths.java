/*
 * TC: O(n x m)
 * SC: O(n)
 */
import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        // since you're adding "across", one array is enough
        // and the 2 loops simulate addition across rows
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}