Time Complexity - O(m*n)
Space Complexity - O(m*n)

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] distinctPath = new int[m][n];
        
        for(int i = 0; i < m; i++){
            distinctPath[i][0] = 1;
        }
        
        for(int j = 0; j < n; j++){
            distinctPath[0][j] = 1;
        }
        
        for(int i = 1; i < m ; i++){
            for(int j = 1; j < n; j++){
                distinctPath[i][j] = distinctPath[i][j-1] + distinctPath[i-1][j];
            }
        }
        
        return distinctPath[m-1][n-1];
    }
}