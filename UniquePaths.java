// TC - O(m X n)
// SC - O(m X n)

// LC - 62

class Solution {
    public int uniquePaths(int m, int n) {
		// create a new dp array
        int[][] dp = new int[m][n];
        // Iterate over dp array, if i == 0 or j == 0, dp[i][j] will be 1 else we can calculate from top element and left element
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];   
                }
            }
        }
        return dp[m-1][n-1];        
    }
}