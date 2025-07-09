//Time Complexity : O(m*n)
//Space Complexity :O(n)
class Solution {
    public int uniquePaths(int m, int n) {
        int [] dp = new int[n];
        for(int j=0; j<n; j++){
            dp[j] = 1;
        }

        for(int i=m-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                dp[j] = dp[j+1]+dp[j];
        }
    }
    return dp[0];
}
}
