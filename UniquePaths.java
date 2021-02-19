// Time Complexity : The time complexity is O(mn) where m is the number of rows and n is the number of columns
// Space Complexity : The space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int uniquePaths(int m, int n) {

        int[] dp = new int[n];

        dp[0] = 1;

        for(int i=0;i<m;i++){

            for(int j=1;j<dp.length;j++){
                // each cell ourgoing will have sum of 2 incoming paths
                dp[j] = dp[j] + dp[j-1];
            }
        }

        return dp[n-1];

    }
}