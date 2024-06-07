package DP-5;
// TC: O(m*n)
// SC: O(m*n)
public class Problem2 {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        this.memo = new int[m+1][n+1];
        return dfs(0,0,m,n);
    }

    private int dfs(int i, int j, int m, int n){
        //base condition
        if(i==m-1 && j==n-1) return 1;
        if(i==m || j == n) return 0;


        //logic
        int case0=0;
        if(memo[i+1][j] == 0){
            memo[i+1][j]=dfs(i+1,j,m,n);
        }
        case0=memo[i+1][j];

        int case1=0;
        if(memo[i][j+1]==0){
            memo[i][j+1] = dfs(i,j+1,m,n);
        }
        case1=memo[i][j+1];

        return case0+case1;
    }
}
