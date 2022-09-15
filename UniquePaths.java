class UniquePaths {

    /*
     * brute force:
     * At the last cell you can go only right other wise right or down
     * so hitting last cell would become our base case
     * case 1: where he moves right
     * case 2: where he moves down
     * time complexity: 2^(mn)
     * 
     * From the initial cell we can move to the right(1) or down(2)
     * from right we again have 2 options to move down(3) or right(4)
     * from down we have got 2 options right takes you to 3(repeated subproblem) and
     * down(5)
     */

    /*
     * memoization:if something has been evaluated using recursion we store that in
     * some data structure
     * 
     * We are still using the top down recursion
     * when the recursion stack comes back to call recursion on a calculated value
     * it won't call recursion instead will use the calculated value.
     * In normal recursion each cell was getting calculated multiple times but now
     * each cell value is calculated only once
     * Time Complexity: O(mn)
     * 
     */

    /*
     * Tabular Solution:
     * From last column and last row there's only one way of reaching the last
     * column
     * so we can initialize them as all ones and go bottom up
     * dp[i][j] = dp[i+1][j]+dp[i][j+1]
     * //Space Optimization: we can create a 1D array of m or n whichever is smaller
     * dp[i] = dp[i] + dp[i+1]
     */
    int[][] memo;

    public int uniquePaths(int m, int n) {

        /*
         * memo = new int[m][n];
         * return helper2(0,0,m,n);
         */
        return dp2(m, n);
    }

    public int dp1(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;

        }
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;

        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                dp[row][col] = dp[row + 1][col] + dp[row][col + 1];
            }

        }
        return dp[0][0];
    }

    public int dp2(int m, int n) {
        if (m < n)
            dp2(n, m);
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                dp[col] = dp[col] + dp[col + 1];
            }

        }
        return dp[0];
    }

    public int helper1(int i, int j, int m, int n) {

        // base
        if (i == m || j == n)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;

        // logic

        int case1 = helper1(i + 1, j, m, n);
        int case2 = helper1(i, j + 1, m, n);

        return case1 + case2;
    }

    public int helper2(int i, int j, int m, int n) {

        // base
        // we will never go out of bound
        if (i == m - 1 && j == n - 1)
            return 1;

        // logic
        // if memo i+1,j has not been evaluated yet
        int case1 = 0;
        // check inbounds
        if (i < m - 1) {
            if (memo[i + 1][j] == 0) {
                memo[i + 1][j] = helper2(i + 1, j, m, n);
            }
            case1 = memo[i + 1][j];

        }
        int case2 = 0;
        // check inbounds
        if (j < n - 1) {
            if (memo[i][j + 1] == 0) {
                memo[i][j + 1] = helper2(i, j + 1, m, n);
            }
            case2 = memo[i][j + 1];

        }

        return case1 + case2;
    }
}