// Time Complexity :  O(N * M)
// Space Complexity : O(N * M) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        int[][] dp = new int[m][n];
        for(int[] arr: dp)
            Arrays.fill(arr, 1);
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n ; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j-1];
            }
        }
        return dp[m -1][n - 1];
    }
}