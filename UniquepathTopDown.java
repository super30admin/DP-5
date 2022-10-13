class Solution {
    //tc=m*n
    //sc-m*n
    int[][] memo;
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        memo = new int [m][n];
        return helper(0, 0, m , n);
    }
    private int helper(int i,int j, int m,int n)
    {
        //basecase
        if(i == m-1 && j == n-1) return 1;
        if(i<0 || j<0 || i == m || j == n) return 0;
         //logic
         if(memo[i][j] == 0)
         {
         memo[i][j] = helper(i+1,j,m,n) + helper(i,j+1,m,n);
         }      
         return memo[i][j];

    }
}