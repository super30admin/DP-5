/* Time Complexity : O(m*n) 
 *  m - no. of grid rows
 *  n - no. of grid cols */
/* Space Complexity : O(n)*/
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


//Bottom Up DP - 1D
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        //Initialize all cells of dp to '1'
        for(int j = 0; j < n; j++){
            dp[j] = 1;
        }
        //curr cell val = val(curr cell) + val(cell on right)
        for(int i = m-2; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                dp[j] = dp[j] + dp[j+1];
            }
        }
        return dp[0];
    }
}



/* Time Complexity : O(m*n) 
 *  m - no. of grid rows
 *  n - no. of grid cols */
/* Space Complexity : O(m+n)*/

//Bottom Up DP - 2D
/*
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        //Initialize both last row and col cells of the grid to '1'
        for(int i = 0; i < m; i++){
            dp[i][n-1] = 1;
        }
        for(int j = 0; j < n; j++){
            dp[m-1][j] = 1;
        }
        //curr cell val = val(cell on right) + val(bottom cell)
        for(int i = m-2; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}*/