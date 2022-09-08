// tc: o(m*n)
// sc: o(m*n)

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] mat = new int[m][n];
        
        for(int i=0;i<m;i++){
            mat[i][0]=1;
        }
        for(int i=1;i<n;i++){
            mat[0][i]=1;
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                mat[i][j]=mat[i-1][j]+mat[i][j-1];
            }
        }
        
        return mat[m-1][n-1];
    }
}
