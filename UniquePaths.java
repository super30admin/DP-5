import java.util.Arrays;

public class UniquePaths {

    // Time Complexity : O(mn) - For Traversing the dp matrix
    // Space Complexity : O(mn) - For storing the dp matrix
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0) return 0;
        int[][] dp = new int[m+1][n+1];

        for(int i = m-1; i >=0 ; i--){
            for(int j = n-1; j >=0 ; j--){
                if(i == m-1 && j == n-1){
                }else{
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }

    // Time Complexity : O(mn) - For Traversing the given matrix of size m*n
    // Space Complexity : O(n) - For storing the 1-D dp array
    public int uniquePathsWithSpaceOptimized(int m, int n) {
        if(m == 0 && n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = m-2; i >=0 ; i--){
            for(int j = n-2; j >=0 ; j--){
                dp[j] = dp[j+1] + dp[j];
            }
        }
        return dp[0];
    }

}
