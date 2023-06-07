// Time: O(mn)
// Space: O(mn)

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        return recur(dp,m-1,n-1);
        
    }

    private int recur(int[][] dp, int m, int n){
        // 
        if(m<0 || n < 0){
            return 0;
        }
        else if(m ==0 || n == 0){
            return 1;
        }else if(dp[m][n]>0){
            return dp[m][n];
        }else{

        // 
        dp[m][n] =  recur(dp, m, n-1) + recur(dp,m-1 ,n);
        return  dp[m][n];
        }
    }
}