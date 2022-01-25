// Time Complexity : exponential
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We try solving it using dfs
// we write a recursive function that takes m,n and r and c
// While we are in the grid we do the addition on dfs when we increase and dfs when we increase the c
// As it is exponential TC, we will get timelimit exceeded

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0)
            return 0;

        return dfs(m, n, 0, 0);
    }

    public int dfs(int m, int n, int r, int c) {
        if (r == m - 1 && c == n - 1)
            return 1;
        if (r == m || c == n)
            return 0;

        return dfs(m, n, r + 1, c) + dfs(m, n, r, c + 1);
    }
}

// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We solve this using dp
// we create a 2d dp array, to manage the repeated subproblems
// we do bottom up and add the left and right to get dp value

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0)
            return 0;
        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1)
                    continue;
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }
        return dp[0][0];
    }
}

// Time Complexity : O(mn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We solve this using dp
// we create a 1D dp array, to manage the repeated subproblems
// we do bottom up and add the left and right to get dp value
// We optimise the space by using 1D array, logic is same as above
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0)
            return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {

                dp[j] = dp[j + 1] + dp[j];
            }
        }
        return dp[0];
    }
}