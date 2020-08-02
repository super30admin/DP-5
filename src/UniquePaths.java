// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * 
 * https://leetcode.com/problems/unique-paths/submissions/
 *
 */
class Solution {
    public int uniquePaths(int m, int n) {
        
       int[][] dp = new int[m][n];
        
        for(int j=0; j<n;j++){
            dp[m-1][j] = 1;
        }
        
        for(int i=0; i<m;i++){
            dp[i][n-1] = 1;
        }
        
        for(int i = m-2; i>=0; i--){
            for(int j = n-2; j>=0; j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        
        return dp[0][0];
    }

    //brute force 2^ (m*n) solution
    private int bruteForce(int i, int j, int m, int n){
        //base
        if(i == m-1 && j == n-1) return 1;
        
        if(i >= m || j >= n) return 0;
        
        //logic
        int right = bruteForce(i, j+1, m, n);
        int down = bruteForce(i+1, j, m, n);
        
        return right + down;
        
    }
}