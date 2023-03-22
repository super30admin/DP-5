//Top down dp problem
//TC: O(mn)
//SC: O(mn) + for recurssion O(m+n) 

class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        //null
        if(m == 0 || n== 0) return 0;
        memo = new int[m][n];
        return dfs(0,0,m,n);
    }
    private int dfs(int i, int j, int m, int n){
        //base
        if(i == m-1 && j == n-1) return 1;
        if(i<0 || i ==m || j<0 || j==n) return 0;
        
        //logic
        if(memo[i][j] == 0){
            memo[i][j] = dfs(i+1,j,m,n) + dfs(i,j+1,m,n);
        }
        return memo[i][j];
    }
}
