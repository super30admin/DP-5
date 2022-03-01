// Time Complexity : Add : O(M*N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Arrays;

public class UniquePaths{
    public static void main(String[] args) {
        int m = 3, n = 7;
        uniquePaths(m,n);
    }

    public static int uniquePaths(int m, int n) {
        //base
        if(m == 0 && n == 0 )
            return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // Bottom Up approach
        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                dp[j] = dp[j+1] + dp[j];   // down + right
            }
        }

        return dp[0];

    }
}

