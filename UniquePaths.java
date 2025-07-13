TC : O(M*N)
SC : O(N)


class Solution {
    public int uniquePaths(int m, int n) {
        int []dp = new int[n+1];
        for(int j =0; j<n;++j)
            dp[j] = 1;
        for(int i = m-2; i > -1 ; i--){
            for(int j = n-2; j> -1; j--){
                dp[j] = dp[j+1]+dp[j];
            }
        }
        return dp[0];
    }
}
