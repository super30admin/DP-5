// Time Complexity : O(m*n) m*n is the size of matrix
// Space Complexity : O(m) m size of row in matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class UniquePaths {
    public int uniquePaths(int m, int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp, 1);
        dp[n] = 0;
        for(int i = m-2;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                dp[j] = dp[j+1] + dp[j];
            }
        }
        return dp[0];
    }

    public static void main(String [] args){
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(3,7));
    }
}