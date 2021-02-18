// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int uniquePaths(int m, int n) {
        //create the dp area with extra row and col
        int [][] dp = new int [m+1][n+1];
        //put 1 at the exit because there is only one path
        dp[m-1][n-1] = 1;
        //start for loop to go through the matrix from the last index
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                //if you are at the last index skip over it
                if(i == m-1 && j == n-1) continue;
                //otherwise add the nearest paths
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        //return the first index which is the total number of paths
        return dp[0][0];
    }
}