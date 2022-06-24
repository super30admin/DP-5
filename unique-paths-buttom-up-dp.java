class Solution {
    // Buttom up DP Solution
    // Time complexity is O(mn)
    // Space complexity is O(mn)
    // This solution is submitted with zero errors
    public int uniquePaths(int m, int n) {
        // Edge case
        if(m == 0 || n ==0 ) return 0;
        int [][]dp = new int [m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i = m-1; i >=0; i--){
            for(int j = n-1; j>= 0; j--){
                // since we do 0+0 and we need 1
                if(i == m-1 && j == n-1) continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];    
    }
}