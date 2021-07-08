// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes. 
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach
class UniquePaths {
    public int uniquePaths(int m, int n) {
        int grid[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    grid[i][j] = 1;
                }else{
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
        return grid[m-1][n-1];
    }
}