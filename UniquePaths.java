package DP-5;
// Time Complexity : O(m*n) m is number of rows and n is number of cols
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class UniquePaths {
    class Solution {
        public int uniquePaths(int m, int n) {
            
            int dp[] = new int[n];
            Arrays.fill(dp,1);
            for(int i=m-2;i>=0;i--)
            {
                int right = 0;
                for(int j=n-1;j>=0;j--)
                {
                   
                    dp[j] = dp[j] + right;
                    right = dp[j];
                }
            }
            return dp[0];
        }
    }
}
