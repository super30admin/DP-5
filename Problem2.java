class Problem2 {
    int [][] memo ;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        //return dpTabulation(m,n);
        //return recurHelper(m,n,0,0);
        return memoizeHelper(m,n,0,0);

    }

    //TC : O(M*N)
    //SC : O(M*N)
    public int dpTabulation(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    dp[i][j]=1;
                }else{
                    dp[i][j] =  dp[i-1][j]+ dp[i][j-1];
                }

            }
        }
        return dp[m-1][n-1];
    }

    //TC : O(2^(M+N))
    //SC : O(2^(M+N))
    public int recurHelper(int m,int n,int r, int c) {
        // base condition
        if(r==m-1 || c==n-1){
            return 1;
        }
        if(r>=m || c>=n ){
            return 0;
        }
        int chose0 = recurHelper(m,n,r+1,c);//go down
        int chose1 = recurHelper(m,n,r,c+1);//go right

        return chose0+chose1;

    }

    //TC : O(M*N)
    //SC : O(M*N)
    public int memoizeHelper(int m,int n,int r, int c) {
        // base condition
        if(r==m-1 || c==n-1){
            return 1;
        }
        if(r==m || c==n ){
            return 0;
        }
        if(memo[r][c] !=0){
            return memo[r][c];
        }

        int chose0 = memoizeHelper(m,n,r+1,c);//go down
        int chose1 = memoizeHelper(m,n,r,c+1);//go right
        memo[r][c] = chose0+chose1;





        return memo[r][c];

    }

}