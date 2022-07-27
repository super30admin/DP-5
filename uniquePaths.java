// approch 1
// Time Complexity : O(2^mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 3
// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 4
// Time Complexity : O(mn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {
    // approch 1 recursive brute force
    public static int uniquePaths1(int m, int n) {
        return helper1(0, 0, m, n);
    }

    private static int helper1(int i, int j, int m, int n) {
        // base case
        if (i == m || j == n)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;
        // main logic
        return helper1(i + 1, j, m, n) + helper1(i, j + 1, m, n);
    }

    // approch 2 top down dp (memorization)
    // memorization table for store already explored paths
    private static int[][] memo;

    public static int uniquePaths2(int m, int n) {
        memo = new int[m + 1][n + 1];
        return helper2(0, 0, m, n);
    }

    private static int helper2(int i, int j, int m, int n) {
        // base case
        if (i == m || j == n)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;
        // main logic

        // we havent explore memo[i+1][j] that means memo[i+1][j] == 0 then we explore
        // this path
        if (memo[i + 1][j] == 0) {
            memo[i + 1][j] = helper2(i + 1, j, m, n);
        }
        // we havent explore memo[i][j+1] that means memo[i][j+1] == 0 then we explore
        // this path
        if (memo[i][j + 1] == 0) {
            memo[i][j + 1] = helper2(i, j + 1, m, n);
        }
        // return sum of memo[i+1][j] && memo[i][j+1]
        return memo[i + 1][j] + memo[i][j + 1];
    }

    // approch 3 bottom up dp using dp matrix
    public static int uniquePaths3(int m, int n) {
        // dp matrix for storing number of paths
        int[][] dp = new int[m + 1][n + 1];
        // number of path at finish line is 1
        dp[m - 1][n - 1] = 1;
        // traverse from the bottom up
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // if i and j at the last index we are not going to do anything as it will
                // already
                // populated with number of paths
                if (i == m - 1 && j == n - 1)
                    continue;
                // else we are going to get numnber of path for current cell from the bottom and
                // right
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }
        // at the end we found number of path at dp[0][0]
        return dp[0][0];

    }

    // approch 4 bottom up dp using dp array
    public static int uniquePaths4(int m, int n) {
        // dp array for storing number of paths
        int[] dp = new int[n + 1];
        // initially all numbers in dp array is filled to 1 as in last row
        // there is always one path
        Arrays.fill(dp, 1);
        // last index would be zero as we are taking one extra element at the end in dp
        // array
        // for avoid checking bound of last cols
        // traverse from the bottom up
        dp[n] = 0;
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // for any index we are getting number of path from sum of right and bottom
                // so
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        // at the end we found number of path at dp[0]
        return dp[0];

    }

    public static void main(String[] args) {
        int m = 23;
        int n = 7;
        long start1 = System.currentTimeMillis();
        System.out.println(uniquePaths1(m, n));
        long end1 = System.currentTimeMillis();
        System.out.println("1. Elapsed Time in mili seconds: " + (end1 - start1));

        start1 = System.currentTimeMillis();
        System.out.println(uniquePaths2(m, n));
        end1 = System.currentTimeMillis();
        System.out.println("2. Elapsed Time in mili seconds: " + (end1 - start1));

        start1 = System.currentTimeMillis();
        System.out.println(uniquePaths3(m, n));
        end1 = System.currentTimeMillis();
        System.out.println("3. Elapsed Time in mili seconds: " + (end1 - start1));

        start1 = System.currentTimeMillis();
        System.out.println(uniquePaths4(m, n));
        end1 = System.currentTimeMillis();
        System.out.println("4. Elapsed Time in mili seconds: " + (end1 - start1));
    }
}