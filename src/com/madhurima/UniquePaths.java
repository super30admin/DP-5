//Time complexity: Sol1: O(2^ m*n), Sol2: O(m*n), Sol3: O(m*n)
//Space Complexity: Sol1: O(m*n) (stack space), Sol2: O(m*n), Sol3: O(n)
//Did the code run successfully in LeetCode = yes

package com.madhurima;

import java.util.Arrays;

public class UniquePaths {
}

class UniquePathsSolution1 {

    //recursion based solution
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0){
            return 0;
        }

        return recurse(m, n, 0, 0);

    }

    private int recurse(int m , int n, int r, int c){
        //base
        if(r == m || c== n){
            return 0;
        }

        if(r == m-1 && c == n-1){
            return 1;
        }


        //logic
        int right = recurse(m, n, r, c+1);
        int bottom = recurse(m, n, r+1, c);

        return right+bottom;

    }

}

class UniquePathsSolution2 {

    //with dp array of size m*n
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0){
            return 0;
        }

        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(i == m-1 && j == n-1){
                    continue;
                }

                dp[i][j] = dp[i][j+1] + dp[i+1][j];

            }
        }

        return dp[0][0];

    }
}

class UniquePathsSolution3 {

    //with dp array of size n
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0){
            return 0;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = m-2; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                dp[j] = dp[j] + dp[j+1];
            }
        }

        return dp[0];


    }
}
