public class Problem2 {

    // DP solution with 2d Array
    // TC : O(m*n)
    // SC : O(m*m)
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        dp[m][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    // DP with 1-D Array
    // TC : O(m*n)
    // SC : O(n)
    public int uniquePaths1(int m, int n) {
        int[] dp = new int[n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j] + dp[j + 1];
                }
            }
        }
        return dp[0];
    }

    //Brut force


    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println("Final value" + problem2.uniquePaths(3, 7));
    }
}
