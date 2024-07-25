class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        this.dp =new  int[m][n];
        int result = helper(0,0,m,n);

        return result;
        
    }
    public int helper(int r, int c, int m, int n){

        //base
        if(r>=m || c>=n) return 0;
        if(r==m-1 && c== n-1) return 1;
        if(dp[r][c]!=0) return dp[r][c];
        
        //logic
        int right = helper(r,c+1,m,n);
        int down = helper(r+1,c,m,n);

        dp[r][c] = right + down;

        return right + down;
        

    }
}