//Time Complexity: O(mn)
//space Complexity:O(mn)
class Solution {
    public int uniquePaths(int m, int n) {
        
        int dp[][]=new int [m+1][n+1];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
//Time Complexity: O(mn)
//space Complexity:O(n)
class Solution {
    public int uniquePaths(int m, int n) {
        
        int dp[]=new int [n];
        Arrays.fill(dp,1);
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[j]=dp[j+1]+dp[j];
            }
        }
        return dp[0];
    }
}
//Time Complexity: O(mn)
//space Complexity:O(mn)
class Solution {
    int memo[][];
    public int uniquePaths(int m, int n) {
        
        memo=new int[m][n];
        memo[m-1][n-1]=1;
        dfs(0,0,m,n);
        return memo[0][0];
    }

    private int dfs(int i, int j, int m, int n){
        //base
        if(i==m||j==n)
            return 0;
        if(memo[i][j]!=0)
            return memo[i][j];
        //logi
        memo[i][j]=dfs(i+1,j,m,n)+dfs(i,j+1,m,n);
        return memo[i][j];
    }
}
