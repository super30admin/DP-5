//dp[i][j] represents unique paths
// base case: First row dp[0][j] and first coloumn dp[i][0] have only 1 way to reach
// for all other cells robot can come from cell above or left

// Time Complexity: O(m * n) . filling the dp table
// Space complexity:  O(m * n) Stroring the dp

public class UniquePaths {
    public static int returnUniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        // fill the first row and first coloumn
        for ( int i = 0; i < m; i++) dp[i][0] = 1;
        for ( int j = 0; j < n; j++) dp[0][j] = 1;

        // fill the rest of the dp
        for ( int i = 1; i < m; i ++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] +  dp[i][j-1] ;
            }
        }
        return dp [m - 1][n - 1];

    }
    public static void main(String[] args) {
        System.out.println(returnUniquePaths(3, 7)); // Output: 28
        System.out.println(returnUniquePaths(3, 2)); // Output: 3
    }
}
