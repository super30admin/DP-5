// Time Complexity : O(m*n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Populate a DP matrix, initially with 1 for the last row and the last column. This indicates that there is only 1 way to reach the last element of the matrix (only movements allowed are going either right or down). Then start filling the matrix in a bottom up approach, so dp[i][j] is equal to the sum of the element to the right and element at the bottom. Later optimize space by using a DP array instead of DP matrix.

public class UniquePaths {
        // Solution 1 : Using DP array
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            
            for(int i = m-2; i >= 0; i--){
                for(int j = n-2; j >= 0; j--){
                    dp[j] = dp[j] + dp[j+1];
                }
            }
            
            return dp[0];
        }
    
        // Solution 2 : Using DP matrix
        // public int uniquePaths(int m, int n) {
        //     int[][] dp = new int[m][n];
            
        //     for(int i = m-1; i >= 0; i--){
        //         for(int j = n-1; j >= 0; j--){
        //             if(i == m-1 || j == n-1){
        //                 dp[i][j] = 1;
        //             } else {
        //                 dp[i][j] = dp[i+1][j] + dp[i][j+1];
        //             }
        //         }
        //     }
            
        //     return dp[0][0];
        // }
}
