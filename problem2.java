class uniquePaths1 {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n== 0) return 0;
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        return dp[0];
    }
}

//time complexity O(m * n)
//space complexity O(n)