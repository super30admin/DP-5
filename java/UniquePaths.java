
// Time Complexity : 2^mn
// Space Complexity : O(mn) recursive stack space
// Did this code successfully run on Leetcode : Time limit Exceeded
// Any problem you faced while coding this : No


class Solution {
    public int uniquePaths(int m, int n) {
        if(m==0 && n==0) return 0;
        return helper(0, 0 , m ,n);
    }

    private int helper(int i, int j, int m, int n){
        //base
        if(i==m || j==n) return 0;
        if(i==m-1 || j==n-1) return 1;
        //logic
        return helper(i+1, j, m, n) + helper(i, j+1, m, n);
    }
}

Approach 2 --- Dp

// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int uniquePaths(int m, int n) {
        if(m==0 && n==0) return 0;

        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1]=1;

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(i==m-1 && j==n-1) continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }
}