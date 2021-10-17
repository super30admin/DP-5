class Solution {
    int [][] table;
    public int uniquePaths(int m, int n) {
        if(m==0 && n == 0) return 0;
        table = new int[m][n];
        return dfs(m,n,0,0);
    }
    
    public int dfs(int m, int n, int i, int j) {
        if(i==m || j==n) return 0;
        if(i==m-1 && j==n-1) return 1;
        int right = 0; int bottom = 0;
        if(j<n-1) {
            if(table[i][j+1]==0) {
                table[i][j+1] = dfs(m, n, i, j+1);
            }
            right = table[i][j+1];
        }
        if(i<m-1) {
            if(table[i+1][j]==0) {
                table[i+1][j] = dfs(m, n, i+1, j);
            }
            bottom = dfs(m,n, i+1, j);
        }
        return right+bottom;
    }
}