// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//DP
//TC : O(mn)
//SC : O(mn)
//Start for last cell : 
//for all m-1 row or n-1 col, we have a path to go to end (last cell)
//other cells in between will have number of paths equal to 
//sum of paths in right and down cell
//so first cell in the end will have the val as total number of 
//unique paths from 1st cell to last cell
//return first cell value as result
class Solution {
    public int uniquePaths(int m, int n) {
        //if either m / n = 1, number of unique path is 1
        if(m == 1 || n == 1) return 1;
        //create extra dp array
        int[][] dp = new int[m][n];
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >=0; j--) {
                //set last row and col = 1
                if(i == m-1 || j == n-1) {
                    dp[i][j] = 1;
                }
                else {
                    //else value of cell is sum of values of right and down cell
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        //return first cell value
        return dp[0][0]; 
    }
}