// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];

        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (i>0&&j>0) {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                } else {
                    dp[i][j]=1;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
