public class UniquePaths_BruteForce {
    public int uniquePaths(int m, int n) {
        // null case
        if(m==0 || n==0) return 0;
        return dfs(0,0,m,n);
    }
    private int dfs(int i, int j, int m, int n){
        // base
        if(i==m-1 && j==n-1) return 1;
        if(i<0 || j<0 || i==m || j==n) return 0;

        // logic
        return dfs(i,j+1,m,n) + dfs(i+1,j,m,n);
    }
}

// Time Complexity - O(2 power mn)
// Space Complexity - O(m*n)

public class UniquePaths_Optimized_TopDown {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        // null case
        if(m==0 || n==0) return 0;
        memo = new int[m][n];
        return dfs(0,0,m,n);
    }
    private int dfs(int i, int j, int m, int n){
        // base
        if(i==m-1 && j==n-1) return 1;
        if(i<0 || j<0 || i==m || j==n) return 0;

        if(memo[i][j]==0){
            memo[i][j] = dfs(i,j+1,m,n) + dfs(i+1,j,m,n);
        }
        // logic
        return memo[i][j];
    }
}

// Time Complexity - O(m*n)
// Space Complexity - O(m*n)

public class UniquePaths_Optimized_BottomUp {
    public int uniquePaths(int m, int n) {
        if(m==0||n==0) return 0;
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) continue;
                dp[i][j] = dp[i][j+1]+dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}

// Time Complexity - O(m*n)
// Space Complexity - O(m*n)