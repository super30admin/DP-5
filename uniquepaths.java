// TC: O(m*n) since we are iterating the whole matrix
// SC: O(m*n)
public class uniquepaths {
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        if(m==1 || n==1) return 1;
        // creating the matrix
        int[][] dp = new int[m][n];
        // fill first row with 0's
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }
        // fill first col with 0's
        for(int j=0; j<n; j++){
            dp[0][j] = 1;
        }
        // computing the new cell value by using the previous cells
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}