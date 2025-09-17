//TC: O(m·n) — each cell computed once with O(1) work.
//SC: O(n) — single row DP.

//Use 1D DP where dp[j] holds paths to current cell; initialize first row/column as 1.
//For each cell, update dp[j] = dp[j] + dp[j-1] (top + left).
//After filling m×n, answer is dp[n-1].

class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    dp[j] = 1;
                }else{
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }
}
