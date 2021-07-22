
// Time - O(m*n)
// Space - O(n)



class Solution {
    public int uniquePaths(int m, int n) {

        if(m == 0 || n == 0) return 0;

        if(n > m) return uniquePaths(n,m);

        int [] dp = new int[n+1];
        Arrays.fill(dp,1);

        for(int i = m -2; i >= 0; i--) { // calculate the values one row before the bottom row

            int right = 0; // set the right to 0

            for(int j = n -1; j >= 0; j--) { // bottom row

                dp[j] = dp[j] + right;
                right = dp[j]; // reset right to calculated value of dp[j]

            }

        }

        return dp[0];


    }
}



// Time - O(m*n)
// Space - O(m+n)




class Solution {
    public int uniquePaths(int m, int n) {

        if(m == 0 || n == 0) return 0;

        int [][] dp = new int[m+1][n+1];

        dp[m-1][n-1] = 1; // putting the last column and last row element value as 1

        for(int i = m-1; i >= 0; i--) {

            for(int j = n-1; j >= 0; j--) {

                if(i == m - 1 && j == n - 1) continue; // dont add the sum of bottom and right value which will give sum of 0

                dp[i][j] = dp[i+1][j]  + dp[i][j+1]; // summation of bottom and right value

            }

        }

        return dp[0][0]; // return first element at 0,0 position

    }
}