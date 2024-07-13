// Time Complexity : O(N * M)
// Space Complexity : O(N * M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// DP using matrix approach - Bottom up approach
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i == m-1 && j== n-1) continue;

                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }
}

// Time Complexity : O(N * M)
// Space Complexity : O(N)
// Using DP Array
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n+1];
        dp[n-1] = 1;

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i == m-1 && j== n-1) continue;

                dp[j] = dp[j] + dp[j+1];
            }
        }

        return dp[0];
    }
}

// Top down approach
class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        this.memo = new int[m+1][n+1];
        return dfs(0,0,m,n);
    }

    private int dfs(int i, int j,int m,int n) {
        //base case
        if(i == m-1 && j== n-1) return 1;

        if(i == m || j== n) return 0;

        if(memo[i][j] != 0) return memo[i][j];
        //
        int case0 = dfs(i+1,j,m,n); // move down
        memo[i+1][j]= case0;
        int case1= dfs(i,j+1, m,n); // move right
        memo[i][j+1]= case1;

        return case0+case1;

    }
}

//Recursive approach
// TC = O(2^(m+n)) - Time Limit Exceeded
//SC: O(N)
class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(0,0,m,n);
    }

    private int dfs(int i, int j,int m,int n) {
        //base case
        if(i == m-1 && j== n-1) return 1;

        if(i == m || j== n) return 0;
        //
        int case0 = dfs(i+1,j,m,n); // move down
        int case1= dfs(i,j+1, m,n); // move right

        return case0+case1;

    }
}