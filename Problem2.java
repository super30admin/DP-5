// Brute Force
// Time Complexity : O(2^mn)
// Space Complexity : O(1)

class Solution {
    int m, n;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        return helper(0, 0);
    }
    
    private int helper(int m, int n){
        if(m>=this.m || n>=this.n)
            return 0;
        if(m==this.m-1 && n == this.n-1)
            return 1;
        
        //right
        int c1 = helper(m, n+1);
        //down
        int c2 = helper(m+1, n);
    
        return c1+c2;
    }
}


// DP Solution
// Time Complexity : O(mn) 
// Space Complexity : O(mn)

class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }
        
        for(int j=0; j<n; j++){
            dp[0][j] = 1;
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        
        return dp[m-1][n-1];
    }
}