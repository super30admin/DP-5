// Time Complexity : O(m*n).
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We performed bottom up tabulation and set the last row of dp array with 1's as there is only one possible direction to move at the last row. We
// perform right to left computation by adding the right and bottom neighbors. Finally we return the first element as it has the maximum possibilites.

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1); //last row with 1
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = dp[j] + dp[j+1]; //sum of right and bottom neighbors
            }
        }
        return dp[0];
    }
}