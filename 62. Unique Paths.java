class Solution {
    public int uniquePaths(int m, int n) {

        if(m < 2) return 1;


        int[][] dp = new int[2][n];

        Arrays.fill(dp[1], 1);

        int[] curr = dp[0];
        int[] prev = dp[1];

        for(int i = m-2; i > -1; i--){
            for(int j = n-1; j > -1; j--){
                if(j == n-1){
                    curr[j] = prev[j];
                } else {
                    curr[j] = prev[j] + curr[j+1];
                }
            }
            prev = curr;
            curr = new int[n];
        }
        
        return prev[0];
    }
}
