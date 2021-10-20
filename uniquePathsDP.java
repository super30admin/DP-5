// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None

public class uniquePathsDP {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0) return 0;
        
        int[][] paths = new int[m][n];
        
        //populate each cell with 1
        for(int[] path: paths) {
            Arrays.fill(path, 1);
        }
        
        //iterate over each row and col index and take the sum from top and left
        for(int r = 1; r < m; r++){
            for(int c = 1; c < n; c++){
                paths[r][c] = paths[r-1][c] + paths[r][c-1];
            }
        }
        
        return paths[m-1][n-1];
    }
}
