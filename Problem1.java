//Unique Paths
//dp 
//tc - O(m*n)
//sc - O(m*n)

class Problem1{
    public static void main(String[] args){
        Problem1 p = new Problem1();
        System.out.println(p.uniquePaths(3, 7));

    }
    public int uniquePaths(int m, int n) {
        if(m ==0 || n==0){
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        for(int i = m-1; i>=0;i--){
            for(int j = n-1; j>=0;j--){
                if(i == m-1 || j == n-1){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }

                }
                
        }
        return dp[0][0];

    }

}