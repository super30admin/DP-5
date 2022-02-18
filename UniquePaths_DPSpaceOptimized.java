//TC: O(m*n)
//SC: O(n) 
//DP -using bottom up approach
//Space optimized to O(n) where n is number of columns
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0) return 0;
        int [] dp = new int[n+1];
        Arrays.fill(dp, 1);
        for(int i = m-2; i >=0; i--){
            for(int j= n-2; j>= 0; j--){
                dp[j] = dp[j+1] +dp[j];
            }
        }
        return dp[0];
    }
}