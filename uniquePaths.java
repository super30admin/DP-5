// TC:O(mn), sc:O(mn)
class Solution {
    int [][] memo;
    public int uniquePaths(int m, int n) {
        this.memo = new int [m][n];
        memo[m-1][n-1]=0;
        return helper(0,0,m,n);
    }

    private int helper(int i,int j,int m, int n){
        if(i==m || j==n) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(memo[i][j]!=0) return memo[i][j];
        int right=helper(i,j+1,m,n);
        int bottom = helper(i+1,j,m,n);
        memo[i][j]=right+bottom;
        return memo[i][j];
    }
}