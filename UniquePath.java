
// Time Complexity : O(2^M*N)
// Space Complexity : M*N
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// we have either 0/1 choice to go down or right
// each time we go we add +1 
// for combine path we add case1+case2 (left+down)
// there will be repeated sub problem we might visit the same cell again
// so use dp and memoize it or use bottom up as well

public class Solution {

    int[][] memo;

    public int uniquePaths(int m, int n) {

        this.memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return helper(0, 0, m, n);
    }

    private int helper(int i, int j, int m, int n) {

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (i == m || j == n) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int case1 = helper(i + 1, j, m, n);
        int case2 = helper(i, j + 1, m, n);

        memo[i][j] = case1 + case2;

        return memo[i][j];
    }
}