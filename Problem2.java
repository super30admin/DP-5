// Time Complexity - O(mn) where m is the number of rows and n is the number of columns of the grid
// Space Complexity - O(mn) where m is the number of rows and n is the number of columns of the grid
// This solution worked on LeetCode

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] =1;
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                if(i == m-1 && j == n-1)    continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
