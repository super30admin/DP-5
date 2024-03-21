// TC : O(m*n)
// SC : o(n)

package S30_Codes.DP_5;

class UniquePaths {
    public int uniquePaths(int m, int n) {
        int dp[] = new int[n];
        dp[n-1] = 1;

        for(int i=m-1; i>=0; i--){
            for(int j=n-2; j>=0; j--){  // starting from n-1 column as n-1 column always has value 1
                        //bottom //Right
                dp[j] = dp[j] + dp[j+1];
            }
        }

        return dp[0];
    }
}