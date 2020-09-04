//TC: O((m*n)^2)
//SC: O(m*n)
class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0,0,m,n);
    }
    
    private int helper(int i, int j, int m, int n){
        //base
        if(i == m-1 && j == n-1) return 1;
        if(i >= m || j>=n) return 0;
        
        //logic
        int right = helper(i,j+1, m, n);
        int down = helper(i+1, j, m, n);
        return right+down;
    }
}

//TC: O(m*n)
//SC: O(1)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        
        for(int i = m-1; i >=0;i--){
            for(int j = n-1; j>=0; j--){
                if(i == m-1 && j == n-1) continue;
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}
