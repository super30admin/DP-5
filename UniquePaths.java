//Time Complexity: O(mxn)
//Space Complexity: O(mxn)
class Solution {
    public int uniquePaths(int m, int n) {
        var dp = new int[m][n];

        for(int i = 0 ; i < m; i++){
            for (int j = 0; j < n ; j++){
                if(i == 0){
                    dp[0][j] = 1;
                }
                else if(j == 0){
                    dp[i][0] = 1;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }

            }
        }

        return dp[m-1][n-1];
    }
}