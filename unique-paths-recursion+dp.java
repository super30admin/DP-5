class Solution {
    // Recursion + top to buttom DP solution
    // Time complexity is O(mn)
    // Space complexity is O(mn)
    // This solution is submitted with zero error
    int [][] dp;
    public int uniquePaths(int m, int n) {
        // Edge case
        if(m == 0 || n ==0 ) return 0;
        dp = new int[m+1][n+1];
        return helper(0,0,m,n);
    }
    
    private int helper(int i, int j, int m, int n){
        // base case
        if(i == m-1 && j == n-1){
            return 1;
        }
        if(i == m || j == n) return 0;
        
        // logic
        if(dp[i+1][j] == 0){
            dp[i+1][j] = helper(i+1,j, m,n);
        }
        int right = dp[i+1][j];
        if(dp[i][j+1] == 0){
            dp[i][j+1] = helper(i,j+1, m,n);
        }
        int buttom = dp[i][j+1];
        return right + buttom;
        // below return also works
        //return dp[i+1][j] + dp[i][j+1];
        
    }
}