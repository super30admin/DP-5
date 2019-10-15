// Time complexity: O(mn)
// Space complexity: O(mn)

// Approach: keep a 2D dp array. The number of ways to reach a cell (i,j) where i>0 and j>0 is given by,
// number of unique paths to top cell + number of unique paths to left cell

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        
        for(int j=0;j<n;j++){
            dp[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
