
// TC: O(m * n) where m and n are rows and cols respectively
// SC: O(m * n) where m and n are rows and cols respectively

// My approach starts from dp[1][1] and ends at matrix[m-1][n-1] 
// which is in opposite direction as taught by Raj Sir. 
// the return values lies in the dp[m-1][n-1]
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7)); // 28
        System.out.println(uniquePaths(3, 2)); // 3
    }

    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int row = 0; row < m; row++) {
            dp[row][0] = 1;
        }
        for (int col = 0; col < n; col++) {
            dp[0][col] = 1;
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}