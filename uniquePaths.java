//Time Complexity: O(mn)
//Space Complexity: O(m)

//bottom-up DP

class uniquePaths {
    public int uniquePaths(int m, int n) {
        if(m>n) return uniquePaths(n, m);

        //we're using the array with smallest size among m or n.
        int[] dp = new int[m];
        for(int i=0; i<m; i++){
            dp[i] = 1;
        }
        for(int j=n-2; j>=0; j--){
            for(int i=m-2; i>=0; i--){
                dp[i] = dp[i]+dp[i+1];
            }
        }
        return dp[0];
    }
}