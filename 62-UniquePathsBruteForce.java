class Solution {
    public int uniquePaths(int m, int n) {
        
        return helper(0, 0, m, n); //starting from 0,0 index
    }
    
    private int helper(int i, int j, int m, int n){
        
        //base
        if(i==m-1 && j == n-1) return 1;
        if(i >= m || j >= n) return 0; 
        //logic
        
        return helper(i+1, j, m, n) + helper(i, j+1, m, n);
    }
}