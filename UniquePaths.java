// Time Complexity : O(mn)
// Space Complexity :O(n), dp array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// maintain dp array which indicates possible paths to get there
// dp[i] = dp[i] + dp[i-1], ways to get there from left and from top
// return dp[n-1] 

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        
        for(int j=0; j<n; j++){
            dp[j] = 1;
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[j] = dp[j] + dp[j-1];
    
            }
        }
        
        return dp[n-1];
    }
}