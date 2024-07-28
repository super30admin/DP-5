/*
    LC - 62. Unique Paths
    TC - O(m * n)
    SC - O(n)
    Approach -
        Two direction is possible. Down and Right which is row and column.
        Fill the n size array to 1
        Traverse the matrix from m-2, n-2, add dp[j] +dp[j+1]
        return dp[0]

*/

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=m-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                dp[j] = dp[j] + dp[j+1];
            }
        }
        return dp[0];
    }
}

/*
    LC - 62. Unique Paths
    TC - O(m * n)
    SC - O(m * n)
    Approach -
        Two direction is possible. Down and Right which is row and column.
        dp[m-1][n] = 1
        Traverse from bottom right end, add the right cell and bottom cell and store in the dp 
        return dp[0][0]
*/

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0) {
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n] = 1;
        for(int i = m-1; i>=0; i--) {
            for(int j = n-1; j>=0; j--) {
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}

/*
    LC - 62. Unique Paths
    TC -  exponential which 2^(m + n)
    Approach -
        Two direction is possible. Down and Right which is row and column.
        base is if row and column reach the m & n
        recursively do both case and return case1 + case 2.
*/

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0) {
            return 0;
        }
        return recurse(m, n, 0, 0);
    }
    private int recurse(int m, int n, int row, int col) {
        // base
        if(row == m || col == n) {
            return 0;
        }

        if(row == m-1 && col == n-1) {
            return 1;
        }


        // logic
        // move in the right direction
        int case1 = recurse(m, n, row, col + 1);
        // move in the down direction
        int case2 = recurse(m, n, row+1, col);

        return case1 + case2;
    }
}