class Solution {
    //Time Complexity:O(n*m)
    //Space Complexity:O(n)
    public int uniquePaths(int m, int n) {
        if (n == 0 && m == 0)
        return 0;
    //    int [][] dp = new int [m+1][n+1]; 
       int[] dp = new int [n]; 
        Arrays.fill(dp,1);

       for (int i = m-2; i >=0;i--){
        for (int j = n-2;j >=0;j--){
            dp[j] = dp[j] + dp[j+1];

        }
       }
       return dp[0];
    }
}
