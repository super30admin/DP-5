package uniquePaths;

// Time Complexity: O(m*n) where m is the number of rows and n is the number of columns
//Time Complexity: O(m × n)

class RecursionUsingMemonization {
    public int uniquePaths(int m, int n) {

        int[][] memo = new int[m][n];

        return helper(0, 0, m ,n, memo);
    }

    private int helper(int i, int j, int m, int n, int[][] memo)
    {
        if(i == m && j == n) {
            return 0;
        }
        // m and n ar ethe boundries
        if(i == m - 1 || j == n - 1) {
            return 1;
        }

        if(memo[i][j] != 0) {
            return memo[i][j];
        }

        // logic -- 2 cases
        int right = helper(i+1, j, m , n, memo);
        int bottom = helper(i, j+1, m , n, memo);

        memo[i][j] = right + bottom;

        return memo[i][j];
    }
}