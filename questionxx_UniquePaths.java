package DynamicProgramming5;

public class questionxx_UniquePaths {
    /***    https://leetcode.com/problems/unique-paths/     */
    /* Created by palak on 7/30/2021 */

    /**
     Bottom Up Dynamic Programming Solution:
         Time Complexity: O(m * n)
         Space Complexity: O(m * n)
         TLE at m = 36 & n = 7.
     */
    public static int uniquePaths1(int m, int n) {
        if(m == 0 && n == 0)    return 0;
        return helper(0, 0, m, n);
    }
    private static int helper(int i, int j, int m, int n) {
        //Base
        if(i == m || j == n)    return 0;
        if(i == m - 1 && j == n - 1)    return 1;
        //Logic
        // int case1 = helper(i + 1, j, m, n);
        // int case2 = helper(i, j + 1, m, n);
        // return case1 + case2;
        return helper(i + 1, j, m, n) + helper(i, j + 1, m, n);
    }

    /**
     Bottom Up Dynamic Programming Solution:
     In this we will start from the bottom right corner of the matrix and check how many unique paths do we find. We will do this until we reach the first cell of the matrix.
     Time Complexity: O(m * n)
     Space Complexity: O(m * n)
     */
    public static int uniquePaths2(int m, int n) {
        if(m == 0 && n == 0)    return 0;
        int[][] dp = new int[m+1][n+1];
        dp[m - 1][n - 1] = 1;

        for(int i = m - 1 ; i >= 0 ; i--) {
            for(int j = n - 1 ; j >= 0 ; j--) {
                if(i == m - 1 && j == n - 1) continue;
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        System.out.println(uniquePaths1(m, n));
        System.out.println(uniquePaths2(m, n));
    }
}