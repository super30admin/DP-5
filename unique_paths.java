//Time Complexity: O(mn)
//Space Complexity: O(mn)

public class unique_paths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1] + 1, dp[i][j - 1] + dp[i - 1][j]);
            }
        }

        return dp[m - 1][n - 1];
    }


}

//using combination math

//Time Complexity: O(m)
//Space Complexity: O(1)
public static int uniquePaths_math(int m, int n) {
    long ans = 1;
    
    for (int x = n, y = 1; y < m; ++x, ++y) {
        ans = ans * x / y;
    }

    return (int) ans;
}
