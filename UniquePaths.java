/*
Time Complexity: O(m * n) - We iterate through the grid in a nested loop.
Space Complexity: O(n) - We use a 1D array of size n to store results.
*/

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = dp[j + 1] + dp[j];
            }
        }
        return dp[0];
    }
}