// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

//memo
class Solution {
    int [][] memo ;
    public int uniquePaths(int m, int n) {
        memo = new int[m+1][n+1];
        return helper(0,0,m,n);
    }
    private int helper(int i, int j, int m, int n){
        //base
        if(i == m || j == n) return 0;
        if(i == m - 1 && j == n-1) return 1;
        //logic
        int right = 0;
        if(memo[i][j+1] == 0){
            memo[i][j+1] = helper(i,j+1,m,n);
        }
        right = memo[i][j+1];
        int bottom = 0;
        if(memo[i+1][j] == 0){
            memo[i+1][j] = helper(i+1,j,m,n);
        }
        bottom = memo[i+1][j];
        return right + bottom;
    }
}

/*
//dp
class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i = m-1; i >=0; i--){
            for(int j = n-1; j >=0;j--){
                if(i == m-1 && j == n-1) continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
    
}
*/
/*
//TLE
class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0,0,m,n);
    }
    private int helper(int i, int j, int m, int n){
        //base
        if(i == m || j == n) return 0;
        if(i == m - 1 && j == n-1) return 1;
        //logic
        return helper(i,j+1,m,n) + helper(i+1,j,m,n);
    }
}
*/