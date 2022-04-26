//Time Complexity O(M*N)
//Space Complexity O(M+N) in case of recursive solution
//Leetcode tested

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][]dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for (int i = m-1; i >=0 ; i--) {
            for (int j = n-1; j >=0 ; j--) {
                if(i == m-1 && j == n-1) continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }

    //recursive solution
    int[][]memo;
    public int uniquePaths2(int m, int n) {
        if(m == 0 && n == 0) return 0;
        memo = new int[m][n];
        return dfs(0,0,m,n);
    }
    public int dfs(int i,int j,int m,int n){
        if(i == m-1 || j == n-1) return 1;
        if(i < 0 || i == m || j < 0 || j == n) return 0;

        if(memo[i][j] == 0)
            memo[i][j] = dfs(i+1,j,m,n) + dfs(i,j+1,m,n);

        return memo[i][j];
    }
}
