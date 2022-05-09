// Time Complexity :m*n
// Space Complexity : m*n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for(int i=0;i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}


class Solution {
    public int uniquePaths(int m, int n) {

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=1;i<m; i++){
            int prev = 1 ;
            for(int j =1; j<n; j++){
                int temp = dp[j] + prev;
                dp[j-1] = prev;
                prev = temp;
            }
            dp[n-1] = prev;
        }

        return dp[n-1];
    }
}
