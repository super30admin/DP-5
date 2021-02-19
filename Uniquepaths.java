//Time Complexity: o(m*n)
//Space Complexity: o(m*n)
//Populate a dp array from the end by storing the sum of the paths available here it is right or down. 
//So some of the right and down paths. Will give the no of paths from current location. when it is the
//last row or last column the path is just 1 because either it is right for row and down for column
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = m-1; i >=0; i--)
        {
            for(int j = n-1; j >=0 ; j--)
            {
                if(i == m-1 || j == n-1) dp[i][j] = 1;
                else
                    dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}