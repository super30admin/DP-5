//way1
//Regular recurssion code
//Travel all the way to exit with right traversal
//Travel all the way to exit with left traversal
//Sum of above two traversal ways
//TC: 2^(m*n)
//SC: (m*n)
class Solution {
    public int uniquePaths(int m, int n) {
        return helper(m,n,0,0);
        
    }

    private int helper(int m, int n, int i, int j){
        //base case
        if(i==m || j==n) return 0;

        if(i==m-1 && j==n-1) return 1;


        //logic
        int right=helper(m,n,i,j+1);
        int down=helper(m,n,i+1,j);
        return right+down;
    }
}


//way2
//Regular recurssion code + memoization
//Travel all the way to exit with right traversal
//Travel all the way to exit with left traversal
//Sum of above two traversal ways
//TC: m*n
//SC: m*n
class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        this.dp=new int[m][n];
        return helper(m,n,0,0);
        
    }

    private int helper(int m, int n, int i, int j){
        //base case
        if(i==m || j==n) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        if(i==m-1 && j==n-1) return 1;


        //logic
        int right=helper(m,n,i,j+1);
        int down=helper(m,n,i+1,j);
        dp[i][j]=right+down;
        return right+down;
    }
}

//way3
//Tabulation
//Start from last box ie., m-1;n-1. From there exit can be done in 1 way
//In last row-- from every box, exit can be done in one way. Fill in dp last row as 1
//All last columns of every row - exit can be done in 1 way. i.e., j==n-1 condition
//At all other blocks: No. of ways = No of ways from right block + No. of ways from left block
//Answer will be present at dp[0][0]
//TC: m*n
//SC: m*n
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        Arrays.fill(dp[m-1],1);

        for(int i=m-2;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(j==n-1){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i][j+1]+dp[i+1][j];
                }
            }
        }

        return dp[0][0];
        
    }
}
