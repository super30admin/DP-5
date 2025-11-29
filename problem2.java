// Time Complexity : O(mn)
// Space Complexity :O(nm)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : i am a bit fuzzy on the logic.

/*
Approach
we are the tabulation methord to solve this problem,
we will first the right and the bottom bounds with 1
then start the dp at m-2,n-2 place taking the sum of the right dp[i][j+1] and  bottom dp [i+1][j]
in the end we will return dp at 0 0
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[m - 1], 1);
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }
        return dp[0][0];
    }
}