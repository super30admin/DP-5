class Solution {
    public int uniquePaths(int m, int n) {
        int [][] memo = new int[m][n];
        return helper(0,0,m,n,memo);
        
    }
    private int helper(int i ,int j, int m, int n,int [][]memo){
        if(i==m-1 || j==n-1) {
            memo[i][j]=1;
            return 1;
        }
        int right=memo[i][j+1];
        if(memo[i][j+1]==0){
            right=helper(i,j+1,m,n,memo);
        }
        int bottom=memo[i+1][j];
        if(memo[i+1][j]==0){
            bottom=helper(i+1,j,m,n,memo);
        }
        memo[i][j]=right+bottom;
        return right + bottom;

    }
}
