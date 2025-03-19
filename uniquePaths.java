// Problem1: (https://leetcode.com/problems/unique-paths/)

// Time Complexity : O(mxn) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take a array dp with size equal to ni.of columns and initially fill them with 1's and try to move from m-2 and n-2 till 0,0 and
 * update dp array using dp[j] = dp[j]+dp[j+1] and finally return dp[0][0].
 */
// 1
class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0, 0, m, n);
    }
    private int helper(int i, int j, int m, int n){
        if(i == m || j ==n) return 0;
        if(i == m-1 || j == n-1) return 1;
        int bottom = helper(i+1, j, m, n);
        int right = helper(i, j+1, m, n);
        return bottom + right;
    }
}
// 2
class Solution {
    public int uniquePaths(int m, int n) {
        int [][] memo = new int[m][n];
        return helper(0, 0, m, n, memo);
    }
    private int helper(int i, int j, int m, int n, int [][] memo){
        if(i == m || j ==n) return 0;
        if(i == m-1 || j == n-1) return 1;
        if(memo[i][j] != 0) return memo[i][j];
        int bottom = helper(i+1, j, m, n, memo);
        int right = helper(i, j+1, m, n, memo);
        memo[i][j] = bottom + right;
        return memo[i][j];
    }
}
// 3
class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m+1][n+1];
        for(int i = 0 ; i<m; i++){
            dp[i][n-1] = 1;
        }
        for(int j = 0 ; j<n; j++){
            dp[m-1][j] = 1;
        }
        for(int i = m-1; i>=0;i--){
            for(int j = n-1; j>=0; j--){
                if(i == m-1 || j == n-1) continue;
                dp[i][j] = dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
// 4 
class Solution {
    public int uniquePaths(int m, int n) {
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = m-2; i>=0;i--){
            for(int j = n-2; j>=0; j--){
                dp[j] = dp[j]+dp[j+1];
            }
        }
        return dp[0];
    }
}