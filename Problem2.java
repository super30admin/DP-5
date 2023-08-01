package DP_5;

/**
 * Using bottom up DP to store the no of paths possible from each cell to
 * destination.
 * 
 * Time Complexity : O(m*n) where m is no of rows and n is no of cols 
 * 
 * Space Complexity : O(n), for the dp arr where n is the no of cols given
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */

public class Problem2 {
    public int uniquePaths(int m, int n) {
        
        int dp[]= new int[n];

        for(int i=0;i<n;i++){
            dp[i]=1;
        }
        
        for(int i=0;i<m-1;i++){
            dp[n-1]=1;
            for(int j=n-2;j>=0;j--){
               dp[j]=dp[j+1]+dp[j];
            }
        }

        return dp[0];
    }
}
