/**LC-62
 * 
 * Time Complexity : exponential
 * Space Complexity : O(mn)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 * 
 * Algorithm:
 * 1. we start from the right bottom index once we initialize it to 1.
 * 2. For each cell, the total no. of unique paths are addition of the total number of parth of right cell and total nummber of path of bottom cell
 */
class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i = m-1; i>= 0; i--){
            
            for(int j = n-1; j>=0; j--){
                
                if(i ==m -1 && j == n-1){
                    
                }
                else{
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
                    
            }
        }
        
        return dp[0][0];
    }

}