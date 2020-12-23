/**
 * TC : O(mn) SC : O(mn)
 * Approach : Create a dp grid and for each and every new ccell add the path if it has any path from top and left. 
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] mat = new int[m+1][n+1];
        mat[1][1] = 1;
        
        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j++){
                if(i != 1 || j != 1) mat[i][j] = mat[i-1][j] + mat[i][j-1];
            }
        }
        // for(int i = 0; i <= m; i ++){
        //     System.out.println();
        //     for(int j = 0; j <= n; j++){
        //         System.out.print(mat[i][j]);
        //     }
        // }
        return mat[m][n];
    }
}