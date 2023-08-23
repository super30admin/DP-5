// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
public class UniquePathUsingDP1DArr {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        dp[n-1] = 1;

        for(int i=m-1; i>=0; i--)
        {
            for(int j=n-2; j>=0; j--)
            {
                dp[j] = dp[j] + dp[j+1];
            }
        }

        return dp[0];

    }
}
