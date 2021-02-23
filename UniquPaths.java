class Solution {

    /*
      Time : O(N) | going over only dp array
      Space : O(M*N) | DP array 
      Leetcode : YES
    */
    
    /*
      Approach:
      1. Starting at destination - 1 (Bottom up) we only have one path to reach destination.
       __ __ __ __
      |__|__|__|__|
      |__|__|__|1_|
      |__|__|1_|D_|
      2. now start filling in middle element of those two 1's as sum of those two paths.
      3. as you reach to 0,0 you have your answer.
    */
    public int uniquePaths(int m, int n) {
        
        int[][] grid = new int[m][n];
        
        for(int i = 0; i < m; i++){
            grid[i][n - 1] = 1;
        }
        
        for(int j = 0; j < n; j++){
            grid[m-1][j] = 1;
        }
        
        for(int i= m - 2; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                grid[i][j] = grid[i+1][j] + grid[i][j+1];
            }
        }
        
        return grid[0][0];  
    }
    
    /*
      Time : Exponential
      Space : O(MxN) | not sure about this pls comment if I'm wrong
      Leetcode : TLE
     */
    public int uniquePaths(int m, int n) {
        return helper(m,n,0,0,);
    }
    
    int helper(int m, int n, int i, int j){
        //base
        if(i == m - 1 && j == n - 1) return 1;
        if(i == m || j == n) return 0;
        
        // logic
        return helper(m, n, i, j+1) + helper(m, n, i+1, j);
    
    }
}
