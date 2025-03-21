// Time Complexity : O(m*n) where m*n is the size of the matrix.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for(int i=0; i<n; i++)
            dp[i] = 1;

        for(int i=0; i<m-1; i++)
        {
            for(int j = n-2; j>=0; j--)
            {
                dp[j] = dp[j] + dp[j+1];
            }
        }
        return dp[0];
    }
}