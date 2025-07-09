//Time Complexity: O(m*n)
// Space Complexity: O(m*n) for the memoization table
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No
// Three line explanation of solution in plain english:
// 1. We are using a memoization table to store the number of unique paths from each cell to the destination cell.
// 2. We recursively explore the paths from the current cell to the right and down.
// 3. The base case is when we reach the destination cell, in which case we return 1,and if we go out of bounds, we return 0. The final result is the number of unique paths from the top-left cell to the bottom-right cell.


class Solution {
    // Memoization table to store the number of unique paths from each cell
    int [][] memo;

    public int uniquePaths(int m, int n) {
        this.memo=new int[m][n];
        // Initialize the memoization table with -1 to indicate unvisited cells
        for (int[] row : memo) {
            Arrays.fill(row, -1); 
        }
        return findPaths(0,0,m,n);
    }
    private int findPaths(int r,int c,int m,int n)
    {   
        // Base case: if we reach the destination cell, return 1
        if(r==m-1 && c==n-1) return 1;
        // If we go out of bounds, return 0
        if(r==m || c==n) return 0;
        // If the current cell has already been visited, return the stored result
        if (memo[r][c]!=-1){
            return memo[r][c];
        }
        // Recursively explore the paths to the right and down, and store the result in the memoization table
        memo[r][c]=findPaths(r,c+1,m,n)+findPaths(r+1,c,m,n);
        return memo[r][c];
    }

}