//Using DP 
class Solution {
    public int uniquePaths(int m, int n) {
        //Tc: O(m*n)  Sc: O(m*n)
        int[][] grid = new int[m][n];
        helper(grid, m, n);
        return grid[0][0];
    }

     private void helper(int[][] grid, int m, int n) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i + 1][j] + grid[i][j + 1];
                }
            }
        }
    }
}




/* 

//Using Recursion
class Solution {
    public int uniquePaths(int m, int n) {
        //Tc: O(2^(m+n)) Sc: O(m+n)
        return helper(0,0,m,n);     
    }

    private int helper(int i, int j, int m, int n)
    {
        if(i == m || j == n) return 0;
        if(i == m-1 && j == n-1) return 1;

        return helper(i, j+1, m, n) + helper(i+1,j,m,n);
    }
}

*/



