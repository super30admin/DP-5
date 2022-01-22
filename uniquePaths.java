// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach 1: with 2d dp array
// Time Complexity = O(mn)
// Space Complexity = O(mn)

// Approach 2: with 1d dp array
// Time Complexity = O(mn)
// Space Complexity = O(n)

// Your code here along with comments explaining your approach
// This is approach 1 with dp array of size m*n
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0) return 0;
        int[][] dp = new int[m+1][n+1];

        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if(i == m-1 && j == n-1) {
                    dp[i][j]=1;
                }
                else {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}

// This is approach 2 with dp array of size n
// This is approach 2 with dp array of size n
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i=m-2; i>=0; i--) {
            for (int j=n-2; j>=0; j--) {
                dp[j] = dp[j] + dp[j+1];
            }
        }
        return dp[0];
    }
}