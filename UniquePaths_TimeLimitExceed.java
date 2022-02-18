//TC: 2^(mn) -- Time limit exceec
    
    
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0) return 0;
        return dfs(0, 0, m, n); 
    }
    public int dfs(int i, int j, int m, int n){
        //base
        if(i == m || j == n) return 0;
        if(i == m-1 && j == n-1) return 1;
        
        //logic
        return dfs(i+1, j, m, n) + dfs(i, j+1, m, n);
    }
}