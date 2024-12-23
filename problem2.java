public class problem2 {

    // Time Complexity: 0(m*n)
    // Space Complexity: O(m*n)

    int [][] memo;
    public int uniquePaths(int m, int n) {
        this.memo = new int[m][n];
        return helper(m,n,0,0);
    }
    public int helper(int m, int n, int i, int j) {
        if (i==m-1 && j==n-1) return 1;
        if(i==m || j==n) return 0;

        if(memo[i][j]!=0) return memo[i][j];
        int case0=helper(m,n,i+1,j);
        int case1=helper(m,n,i,j+1);
        memo[i][j]= case0+case1;
        return memo[i][j];
    }
}
