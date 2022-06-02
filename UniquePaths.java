// O(m * n) time and space: m rows and n columns

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        
        for (int[] arr : grid){
            Arrays.fill(arr, 1);
        }
        
        for (int row = 1; row < m; ++row){
            for (int col = 1; col < n; ++col){
                grid[row][col] = grid[row - 1][col] + grid[row][col - 1]; // can move down or right
            }
        }
        return grid[m - 1][n - 1];
    }
}