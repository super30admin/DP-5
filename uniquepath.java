//Time complexity: o(mn)
//space: o(mn)

class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        
        for(int i = m-1; i>= 0; i--){
            for(int j = n-1; j>=0; j--){
                if( i == m-1 && j == n-1) continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}

//Optimal Solution

//TC: O(m*n)
//SC: O(n)

class Solution {
    public int uniquePaths(int m, int n) {
        if(m < n) return uniquePaths(n, m);
        
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for(int i = m-2; i>=0; i--){
            int right = 0;
            for(int j = n-1; j>=0; j--){
                dp[j] = dp[j] + right;
                right = dp[j];
            }
        }
        return dp[0];
    }
}
 
