//Bottom up DP
//Time Complexity: O(mn)
//Space Complexity: O(mn)

/*
 * here we maintain a temp dp which has number of ways i can reach
 * to the solution from each point.  
 */

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                System.out.println(i + " " + j);
                if(i == m-1 || j == n-1){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}

//Top down DP
//Time Complexity: O(mn)
//Space Complexity: O(mn)

/*
 * for top down approach we call the helper function and caluclate
 * dp for right and down and add it. if it is the boundry condition return 1
 * and if there solution is present we return that.
 */

class Solution {
    public int uniquePaths(int m, int n) {
        return helper(m-1, n-1, new int[m][n]);
    }

    public int helper(int m, int n, int[][] dp){
        //base
        if(m == 0 || n == 0) return 1;
        else if(dp[m][n] != 0) return dp[m][n];

        //logic
        int right = helper(m-1, n, dp);
        int down = helper(m, n-1, dp);
        dp[m][n] = right + down;
        return dp[m][n];
    }
}