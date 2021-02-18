class Solution {


    public int uniquePaths(int m, int n) {

        int[][] dpMatrix = new int[m+1][n+1];
        dpMatrix[m-1][n-1] = 1;
        for(int i = m -1; i >= 0; i--) {
            for(int j = n -1; j >= 0; j--) {

                if(i == m-1 && j == n -1) continue;

                dpMatrix[i][j] = dpMatrix[i+1][j] + dpMatrix[i][j+1];
            }
        }

        return dpMatrix[0][0];
    }

    public int uniquePathsRecursive(int m, int n) {

        if(m == 1 || n == 1)
            return 1;

        return uniquePaths(m-1,n) + uniquePaths(m,n-1);
    }
}
