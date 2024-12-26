public class UniquePath {
    //tabulation approach - o(mn)
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         if(i == 0 || j == 0){
        //             //to fill the top and left as 1 
        //             dp[i][j] = 1;
        //         }else dp[i][j] = dp[i-1][j] + dp[i][j-1];
        //     }
        // }
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j >= 0; j--){
                if(i == m-1 || j == n-1){
                    //bottom or right will be set as 1
                    dp[i][j] = 1;
                }else dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }

    //recursion 2^(m+n)
    //memoization - m*n
    // int memo[][];
    // public int uniquePaths(int m, int n){
    //     this.memo = new int[m][n];
    //     return helper(m, n, 0,0);
    // }

    // public int helper(int m, int n, int i, int j){
    //     //base 
    //     if(i == m-1 && j == n-1){
    //         return 1;
    //     }
    //     if(i == m || j == n){
    //         return 0;
    //     }

    //     //logic 
    //     int case0 = helper(m, n, i+1, j);
    //     int case1 = helper(m, n, i, j+1);
    //     return case0+case1;
    // }

    //dp - memoization way
    //  public int helper(int m, int n, int i, int j){
    //     //base 
    //     if(i == m-1 && j == n-1){
    //         return 1;
    //     }
    //     if(i == m || j == n){
    //         return 0;
    //     }
    //     if(memo[i][j] != 0) return memo[i][j]; 

    //     //logic 
    //     int case0 = helper(m, n, i+1, j);
    //     int case1 = helper(m, n, i, j+1);
    //     memo[i][j] = case0+case1;
    //     return memo[i][j];
    // }
}
