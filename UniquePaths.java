/***
 Using 1D DP (Bottom up)
 TC - O(m*n)
 SC - O(n)
 */
class UniquePaths {
    public int uniquePaths(int m, int n) {

        int[] dp = new int[n];

        dp[0] = 1;

        //initialize dp as 1
        for(int i=1; i < n; i++) {
            dp[i] = 1;
        }

        for(int i=1; i < m ; i++) {
            for(int j =1; j < n; j++) {
                //no of unique ways = no of ways to reach its immediate left and up
                dp[j] = dp[j] + dp[j-1];
            }
        }

        return dp[n-1];

    }
}