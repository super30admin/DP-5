//time O(mn)
//space O(mn)

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] mat = new int[m][n];
        return helper(0, 0, m, n, mat);
    }
    
    private int helper(int r, int c, int m, int n, int[][] mat) {
        if(r > m-1 || c > n-1) return 0;
        if(r == m-1 && c == n-1) return 1;
        if(mat[r][c] != 0) return mat[r][c];
        
        
        //logic
        int right = helper(r, c+1, m,n,mat);
        int down = helper(r+1, c,m,n,mat);
        int re = right + down;
        mat[r][c] = re;
        return re;
    }
}
