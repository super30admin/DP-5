import java.util.Arrays;

// Approach 1: Using Recursion and Memoization
// Time Complexity: O(m*n)
// Space Complexity: O(m*n)
// m,n -> dimensions of the grid
// m -> number of rows
// n -> number of columns
public class LC62 {
    public int topDown(int m, int n, int dp[][]) {
        if (m < 0 || n < 0)
            return 0;
        if (m == 0 && n == 0)
            return 1;
        if (dp[m][n] != -1)
            return dp[m][n];
        return dp[m][n] = topDown(m - 1, n, dp) + topDown(m, n - 1, dp);
    }

    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int xdp[] : dp)
            Arrays.fill(xdp, -1);
        return topDown(m - 1, n - 1, dp);
    }
}


// Approach 2: Using Bottom-Up DP
// Time Complexity: O(m*n)
// Space Complexity: O(n)
// m,n -> dimensions of the grid
// m -> number of rows
// n -> number of columns
class LC62_1 {
    public int uniquePaths(int m, int n) {
        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = 0;
                if (j > 0)
                    left = dp[j - 1];
                dp[j] += left;
            }
        }
        return dp[n - 1];
    }
}