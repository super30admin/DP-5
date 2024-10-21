// Time Complexity : O(mxn) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

package DP-5;

public class Problem2 {
    public int uniquePaths(int m, int n) {
        int dp [] = new int [n];
        Arrays.fill(dp,1);
        for(int i = m - 2; i >=0; i--){
            for(int j = n - 2; j >= 0; j--){
                dp[j] = dp[j] + dp[j+1];
            }
        }
        return dp[0];
    }  
}
