//recursive approach
//tc: O(mn^2)
//sc: O(MN^2) fro stack - need t confirm with Mam.
class Solution {
    public int uniquePaths(int m, int n) {

        return helper(m, n, 0, 0);
    }

    private int helper(int m, int n, int r, int c) {
        // base case with out of bounds
        if (r == m || c == n)
            return 0;

        if (r == m - 1 && c == n - 1)
            return 1;

        // recurse
        int right = helper(m, n, r, c + 1);
        int bottom = helper(m, n, r + 1, c);

        return right + bottom;
    }
}

// recursive approach with Memoization - Top down, wehere we solve the
// subproblems and t=return back with storing its value
// recurion with top down approach, will keep on going until find the
// subroroblem, and on its way back to recursie call, will store the answers.
// tc: O(mn)
// sc: O(mn) + stack space

class Solution {

    int[][] path;

    public int uniquePaths(int m, int n) {
        path = new int[m + 1][n + 1];

        return helper(m, n, 0, 0);
    }

    private int helper(int m, int n, int r, int c) {
        // base case
        if (r == m || c == n)
            return 0;
        if (r == m - 1 && c == n - 1)
            return 1;

        int down = 0, right = 0;
        // going down
        if (path[r + 1][c] == 0) {
            path[r + 1][c] = helper(m, n, r + 1, c);
        }
        down = path[r + 1][c];

        // going right
        if (path[r][c + 1] == 0) {
            path[r][c + 1] = helper(m, n, r, c + 1);
        }
        right = path[r][c + 1];

        return right + down;
    }
}

// DP, to avoid repeated sub problems
// take a dp matrix of m+1, n+1; cell val = right+bottom
// tc: O(mn)
// sc:O(mn)

// Memoization - storing the all subproblem values

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0)
            return -1;

        int[][] dp = new int[m + 1][n + 1];
        // base case. set last dest as 1.

        dp[m - 1][n - 1] = 1;
        // last col will be n+1-1 = n, so second last is n-1 and same goes for rows
        // by default the m-1 +1 and n-1 +1 rows and col will have 0, so will start from
        // m-2+1 & n-2+1 => m-1, n-1

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1)
                    continue;
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}

// eith 1D Array
// with 1d arrray
// tc: O(mn)
// sc: O(n)
class Solution {
    public int uniquePaths(int m, int n) {
        // base case
        if (m == 0 || n == 0)
            return -1;

        int[] dp = new int[n + 1];
        dp[n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = dp[j + 1] + dp[j];
            }
        }
        return dp[0];
    }

}