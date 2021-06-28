package DP5;

import java.util.Arrays;

/*

    -------------------------------------------------------------------------------------------------------
    Time complexity : o(m*n)
    space complexity: o(n)
    Did this code run successfully in leetcode : yes
    problems faces : no*/

public class UniquePathDP {

    public int uniquePaths(int m, int n) {

        //create a dp matrix
        int[][] dp = new int[m + 1][n + 1];

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
    
    public int uniquePathsDPWithArray(int m, int n) {

        //create a dp array
        int[] dpRow = new int[n+1];
        Arrays.fill(dpRow,1);

        for (int i = m - 2; i >= 0; i--) {
            int rightSum = 0;
            for (int j = n - 1; j >= 0; j--) {
                dpRow[j] = dpRow[j] +rightSum;
                rightSum = dpRow[j];
            }
        }

        return dpRow[0];
    }

}
