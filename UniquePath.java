//TC : O(m*n)
//SC : O(n)
class Solution {
    public int uniquePaths(int m, int n) {
        //int[][] board = new int[m][n];
        //return helper(board,0,0,m,n);
        return helper2(m,n);
    }
    //bottom up dp with memo
    private int helper2(int m,int n){
        if(m<n) return helper2(n,m);
        
        int[] dp = new int[n];
     
        for(int j=0;j<n;j++)
            dp[j] =1;
        for(int i =m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[j]=dp[j]+dp[j+1];
            }
        }
        return dp[0];
    }
    /*
    private int helper2(int m,int n){
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
            dp[i][n-1] =1;
        for(int j=0;j<n;j++)
            dp[m-1][j] =1;
        for(int i =m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }*/
    
    //top down dp with memo
    private int helper(int[][] board,int r,int c,int m, int n){
        //base
        if(r==m || c==n){
            return 0;
        }
        if(r==m-1 && c==n-1){
            return 1;
        }
        //logic
        int case1=0;
        if(c<n-1){
            if(board[r][c+1] == 0){
            board[r][c+1] = helper(board,r,c+1,m,n);
            }
            case1 = board[r][c+1];
        }
        int case2=0;
        if(r<m-1){
            if(board[r+1][c] == 0){
            board[r+1][c] = helper(board,r+1,c,m,n);
           }
            case2 = board[r+1][c];
        }
        
        return case1+case2;
    }
}
