//Top down dp problem
//TC: O(mn)
//SC: O(mn) + for recurssion O(m+n) 

class Solution {
    int [][] memo;
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0) return 0;
        memo = new int[m][n];
        memo[m-1][n-1] = 1;
        dfs(0,0,m,n);
        return memo[0][0];
        
    }
    public int dfs(int i,int j, int m, int n){
        //base
        if(i == m || j == n) return 0;
        if(memo[i][j] != 0) return memo[i][j];
        
        //logic
        memo[i][j] = dfs(i, j+1, m, n) + dfs(i+1, j, m, n);
        return memo[i][j];
    }
}