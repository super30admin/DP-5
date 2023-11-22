
// Time Complexity : O(m*n)
// Space Complexity :  O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class UniquePaths
 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int j=0;j<n;j++){
            dp[m-1][j]=1;

        }
        for(int i=0;i<m;i++){
            dp[i][n-1] = 1;
        }
        for(int i=m-2;i>=0;i--){
            for(int j= n-2;j>=0;j--){
                dp[i][j] = dp[i][j+1]+dp[i+1][j];
            }
        }
        return dp[0][0];

    }
}