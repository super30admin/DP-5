public class UniquePaths {
    public int uniquePaths4(int m, int n) {
        //bottom up dp
//        TC:O(m*n)
//        SC:O(n)
        int[] dp = new int[n+1];
        dp[n-1] = 1;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                if(i == m -1 && j == n - 1) continue;
                dp[j] = dp[j+1] + dp[j];
            }
        }
        return dp[0];
    }
    public int uniquePaths31(int m, int n) {
        //bottom up dp
//        TC:O(m*n)
//        SC:O(m*n)
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i == 1 && j == 1) continue;
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m][n];
    }
    public int uniquePaths3(int m, int n) {
        //bottom up dp
//        TC:O(m*n)
//        SC:O(m*n)
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m -1 && j == n - 1) continue;
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }
    int[][] memo;
    public int uniquePaths1(int m, int n) {
        // Top Down dp Memoization
//        TC:O(m*n)
//        SC:O(m*n)
        memo = new int[m+1][n+1];
        return dfs(0,0,m,n);
    }
    private int dfs(int i, int j, int m, int n){
        if(i ==m -1 && j==n-1) return 1;
        if(i==m || j ==n) return 0;
        int case1=0,case0=0;
        if(memo[i+1][j] == 0){
            memo[i+1][j] = dfs(i+1,j,m,n);
        }
        case0 = memo[i+1][j];
        if(memo[i][j+1] == 0){
            memo[i][j+1] = dfs(i,j+1,m,n);
        }
        case1 = memo[i][j+1];
        return case1+case0;
    }


    public int uniquePaths2(int m, int n) {
//        TC:O(2^(m+n))
        //recursion
        return dfs2(0,0,m,n);
    }
    private int dfs2(int i, int j, int m, int n){
        //base case
        if(i == m-1 && j==n-1) return 1;
        if(i ==m || j ==n) return 0;
        int case0 = dfs2(i+1,j,m,n);
        int case1 = dfs2(i, j+1, m, n);

        return case0 +case1;
    }
}
