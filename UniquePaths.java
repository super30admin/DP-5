//Memoization
public class UniquePaths {
    int[][] memo;

    public int uniquePaths(int m, int n) {
        this.memo = new int[m][n];
        return helper(m, n, 0, 0);
    }

    private int helper(int m, int n, int i, int j) {
        if (i == m || j == n)
            return 0;

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int case0 = helper(m, n, i, j + 1);
        int case1 = helper(m, n, i + 1, j);

        memo[i][j] = case0 + case1;

        return memo[i][j];
    }
}

//TC: (m*n), SC: (m*n)

//Tabulation
class UniquePathsTabulation {
    int[][] dp;

    public int uniquePaths(int m, int n) {
        this.dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}

//TC: (m*n), SC: (m*n)

//Tabulation 1D Array
class UniQuePaths1DArray {
    int[] dp;

    public int uniquePaths(int m, int n) {
        this.dp = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[n - 1];
    }
}

//TC: (m*n), SC: (n)


//Recursion
class Solution {
    int count;

    public int uniquePaths(int m, int n) {
        helper(m, n, 0, 0);
        return count;
    }

    private void helper(int m, int n, int i, int j) {
        if (i == m || j == n)
            return;

        if (i == m - 1 && j == n - 1) {
            count++;
            return;
        }
        helper(m, n, i, j + 1);
        helper(m, n, i + 1, j);
    }
}

//TC: (2^(m+n)), SC: (m+n)


