//Top down DP
// Time Complexity : O(m*n) 
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes 
// Approach : go exhaustive in finding all possible paths leading to destination.


class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        this.memo = new int[m][n];
        return helper(0,0,m,n);
    }

    private int helper( int r, int c, int m , int n){
        //base
        if(r == m || c == n) return 0;
        if(r == m-1 && c == n-1) return 1;

        if(memo[r][c] != 0){
            return memo[r][c];
        }

        //right
        int right = helper(r,c+1,m,n);
        //down
        int down = helper(r+1,c,m,n);

        return memo[r][c] = right+down;
    }
}

// Bottom up - using tabulation
// Time Complexity : O(m*n) 
// Space Complexity : O(m*n)

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n] = 1;

        for(int i = m-1 ; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }

        return dp[0][0];
    }
}

// Time Complexity : O(m*n) 
// Space Complexity : O(n)

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n+1];
        dp[n-1] = 1;

        for(int i = m-1 ; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                dp[j] = dp[j+1] + dp[j];
            }
        }

        return dp[0];
    }
}