import java.util.Arrays;

/**
 * Leetcode 62. Unique Paths
 * Link: https://leetcode.com/problems/unique-paths/description/
 */
//------------------------------------ Solution 1 -----------------------------------
public class UniquePaths {
    /**
     * Brute force exhaustive recursive solution: at each cell we want to find the possible paths coming from its down
     * element and right cells and sum it up to calculate the result for current cell. DO this recursively until we hit either
     * the last column or row where maximum possible paths for entire row and column is 1.
     *
     * TC: O(2^(m+n))
     * Auxiliary SC: O(1)
     * Recursive stack SC: O(m+n)
     */
    public int uniquePaths(int m, int n) {
        return helper(m, n, 0, 0);
    }

    private int helper(int m, int n, int r, int c) {
        //base
        if (r == m - 1 || c == n - 1) {
            return 1;
        }

        //logic
        return helper(m, n, r + 1, c) + helper(m, n, r, c + 1);
    }
}

//------------------------------------ Solution 2 -----------------------------------
class UniquePaths2 {
    /**
     * improved TC solution with memoization for the same recursion solution from above. Once we calculate max path for
     * a cell we store it in the memo matrix and whenever the result is available to use from memo for subsequent calls
     * use it instead of calculating it again for the same cell.
     *
     * TC: O(m*n)
     * Auxiliary SC: O(m*n)
     * Recursive stack SC: O(m+n)
     */
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return helper(m, n, 0, 0);
    }

    private int helper(int m, int n, int r, int c) {
        //base
        if (r == m - 1 || c == n - 1) {
            return 1;
        }

        //logic
        if (memo[r][c] == 0) {
            memo[r][c] = helper(m, n, r + 1, c) + helper(m, n, r, c + 1);
        }

        return memo[r][c];
    }
}

//------------------------------------ Solution 3 -----------------------------------
class UniquePaths3 {
    /**
     * Bottom up tabulation DP solution with 2D matrix. start from the cell where exit is marked and count max paths
     * backwards. till 0,0 index. This works as current cell max path is sum of left and down cell's answer which DP
     * already holds.
     *
     * TC: O(m*n)
     * SC: O(m*n)
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = 1;
        }

        for (int i = 0; i < m - 1; i++) {
            dp[i][n - 1] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0];
    }
}

//------------------------------------ Solution 4 -----------------------------------
class UniquePaths4 {
    /**
     * Bottom up tabulation DP solution with 1D matrix
     *
     * TC: O(m*n)
     * SC: O(n)
     */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = dp[j] + dp[j + 1];
            }
        }

        return dp[0];
    }
}