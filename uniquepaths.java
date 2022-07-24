//TIme : O(mxn)
//S : O(n)

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        dp[n] = 0;
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        return dp[0];
    }
}