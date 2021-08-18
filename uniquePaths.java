

//Brute Force

//TC: O(2^mn)
//SC: recursive stack space O(mn)
//where m,n are rows and cols
class Solution {
    public int uniquePaths(int m, int n) {
       if(m==0&& n==0)
           return 0;
        return helper(0,0,m,n);
    }
    private int helper(int i,int j,int m,int n){
        //base
        // if(i==m || j==n)
        //     return 0;
        //logic
        if(i == m-1 || j==n-1)
            return 1;
        return helper(i+1,j,m,n)+helper(i,j+1,m,n);
    }
}


//Dynamic Programming


//TC: O(mn)
//SC: O(mn) dp matrix
//where m,n are rows and cols
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0)
            return 0;
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i == m-1 && j == n-1 )
                    continue;
                dp[i][j] = dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}


//DP with 1-D array
//TC: O(mn)
//SC: O(n) 
//where m,n are rows and cols
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0)
            return 0;
        int dp[] = new int[n+1];
        Arrays.fill(dp,1);
        
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[j] = dp[j]+dp[j+1];
            }
        }
        return dp[0];
    }
}