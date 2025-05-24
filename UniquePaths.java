// Time Complexity : O(m * n) where h = ht of BST
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use dynamic programming to count the number of unique paths from the top-left to bottom-right of an m x n grid.
//   - Initialize the first row and column with 1 since there's only one way to reach cells in the first row/column.
//   - For every other cell, the number of ways to reach it is the sum of ways from the cell above and the cell to the left.


public class UniquePaths {
    // //memoization logic - TC = O(m*n) SC = O(m*n) + O(m+n) of stacks
    // int memo[][];
    // public int uniquePaths(int m, int n) {
    //     this.memo = new int[m][n];
    //     return helper(m, n, 0, 0);
    // }

    // private int helper(int m, int n, int i, int j) {
    //     if(i == m - 1 && j == n - 1) {  //reached target found path return 1
    //         return 1;
    //     }

    //     if(i == m || j == n) {  //base case no path return 0
    //         return 0;
    //     }

    //     if(memo[i][j] != 0)   return memo[i][j];
    //     //go right
    //     int case0 = helper(m, n, i, j + 1);

    //     //go down
    //     int case1 = helper(m, n, i + 1, j);

    //     memo[i][j] = case0 + case1;

    //     return memo[i][j];
    // }

    //Tabulation - TC = O(m*n) and SC = O(m*n)
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;   //0th row or 0th column will have only 1 way
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
