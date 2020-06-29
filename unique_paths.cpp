class Solution {
    int count=0;
public:
    /*int uniquePaths(int m, int n) {
        helper(0,0,m,n);
        return count;
    }
    void helper(int i,int j,int m, int n)
    {
        if(i>=m || j>=n)
            return;
        if(i==m-1 && j==n-1)
        {
            count++;
            return;
        }
        helper(i,j+1,m,n);
        helper(i+1,j,m,n);
    }*/
    int uniquePaths(int m, int n) {
        int dp[m+1][n+1];
        for(int i=0;i<m+1;i++)
            for(int j=0;j<n+1;j++)
                dp[i][j]=0;
        dp[m-1][n-1]=1;
        for(int i=m-1;i>=0;i--)
            for(int j=n-1;j>=0;j--)
            {
                if(i==m-1 && j==n-1)
                    continue;
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        return dp[0][0];
    }
};