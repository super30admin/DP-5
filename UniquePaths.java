// Time Complexity : O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// DP
class Solution {
    public int uniquePaths(int m, int n) {
        int a[][] = new int[m][n];
        if(a.length == 0 || a[0].length == 0)
            return 0 ;
        int rows = a.length;
        int cols = a[0].length; 
        int[][]dp = new int[rows+1][cols+1];
        dp[0][1] =1;
        
        for(int i = 1; i < rows+1 ; i++) {
        	for(int j = 1 ; j < cols+1 ; j++){
        		dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[rows][cols];
        
    }
}