// Time Complexity : O(mn)
// Space Complexity :O(mn)
// m is the number of rows and n is the number of columns
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Method 3 - Bottom Up DP with memoization
// TC: O(mn)
// SC: O(mn)
// m is the number of rows and n is the number of columns

class Solution {
    public int uniquePaths(int m, int n) {
        //null check
        if(m == 0 || n == 0)
            return 0;
        int[][] dp = new int[m+1][n+1];
        //dest --> dest : 1 way
        dp[m-1][n-1] = 1;

        for(int i = m-1 ; i >= 0 ; i--){
            for(int j = n-1 ; j >= 0 ; j--){
                if(i == m-1 && j == n-1) continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}

//Method 2 - Top Down DP with memoization
// TC: O(mn)
// SC: O(mn)
// m is the number of rows and n is the number of columns

class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        //null check
        if(m == 0 || n == 0)
            return 0;
        memo = new int[m][n];
        return dfs(0,0,m,n);
    }

    private int dfs(int i, int j, int m , int n){
        //base case
        //reached destination
        if(i == m-1 && j == n-1)
            return 1;

        //bounds check
        if(i < 0 || j < 0 || i == m || j == n)
            return 0;

        //logic
        // make a right call + bottom call only if its a fresh cell
        if(memo[i][j] == 0){
            memo[i][j] = dfs(i,j+1,m,n) + dfs(i+1,j,m,n);
        }
        return memo[i][j];
    }
}


// Method 1 - Recursion - gives TLE on leetcode
// This is because TC: 2^(mn)
// m is the number of rows and n is the number of columns

class Solution {
    public int uniquePaths(int m, int n) {
        //null check
        if(m == 0 || n == 0)
            return 0;

        return dfs(0,0,m,n);
    }

    private int dfs(int i, int j, int m , int n){
        //base case
        //reached destination
        if(i == m-1 && j == n-1)
            return 1;

        //bounds check
        if(i < 0 || j < 0 || i == m || j == n)
            return 0;

        //logic
        // right call + bottom call
        return dfs(i,j+1,m,n) + dfs(i+1,j,m,n);
    }
}