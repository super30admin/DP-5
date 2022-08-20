import java.util.Arrays;

//Time Complexity: O(m*n)
//Space Complexity: O(n)

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = dp[j + 1] + dp[j];
            }
        }
        return dp[0];

    }
}