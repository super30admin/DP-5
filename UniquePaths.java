//time complexity : O(mxn)
//space complexity : O(mxn)

//bottom up DP - code 3

class Solution {
    public int uniquePaths(int m, int n) {

        int dp[][] = new int[m+1][n+1];

        dp[m-1][n-1] = 1; //target square

        for(int i=m-1; i>=0; i--)
        {
            for(int j=n-1; j>=0; j--)
            {
                if(i==m-1 && j==n-1)
                    continue;
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }

        return dp[0][0];

    }
}
