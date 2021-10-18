// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// DP soln - 2d array
class Solution {
    public int uniquePaths(int m, int n) {
        // null
        if(m == 0 && n == 0) return 0;
        int [][] dp = new int [m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(i==m-1 && j==n-1) continue;
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}

// *****************************************

// Optimized space - 1d array
class Solution {
    public int uniquePaths(int m, int n) {
        // null
        if(m == 0 && n == 0) return 0;
        int [] dp = new int [n];
        Arrays.fill(dp,1);
        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                dp[j] = dp[j+1] + dp[j];
            }
        }
        return dp[0];
    }
}

// ***************************************

// Memoization- topdown DP

class Solution {
    int [][] table;
    public int uniquePaths(int m, int n) {
        // null
        if(m == 0 && n == 0) return 0;
        table = new int[m][n];
        table[m-1][n-1] = 1;
        return dfs(m, n, 0, 0);
    }
    private int dfs(int m, int n, int i, int j){
        // base
        if(i==m ||j==n) return 0;
        if(i==m-1 && j==n-1) return 1;
        
        int right = 0;
        if(j < n-1){
            if(table[i][j+1] == 0)
                table[i][j+1] = dfs(m, n, i, j+1);
            right = table[i][j+1];
        }
        
        int bottom = 0;
        if(i < m-1){
            if(table[i+1][j] == 0)
                table[i+1][j] = dfs(m, n, i+1, j);
            bottom = table[i+1][j];
        }
        
        return right + bottom;
    }
}