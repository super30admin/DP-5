/*
Time Complexity = exponential
Space Complexity = exponential
where m is the number of rows and n is the number of coloumns.
*/
class Solution {
public:
    int recurse(int i,int j,int m,int n)
    {
        //base
        if(i==m || j==n)
            return 0;
        if(i==m-1 && j==n-1)
            return 1;
        //logic
        return recurse(i+1,j,m,n)+recurse(i,j+1,m,n);
        
    }
    int uniquePaths(int m, int n) {
        return recurse(0,0,m,n);
    }
};


/*
Time Complexity = O(m*n)
Space Complexity = O(m*n)
where m is the number of rows and n is the number of coloumns.
*/
class Solution {
public:
    int uniquePaths(int m, int n) {
        //vector<vector<int>> dp;
        vector<vector<int>> dp(m, vector<int> (n, 0));
        int i,j;
        
        for(i=m-1;i>=0;i--)
        {
            for(j=n-1;j>=0;j--)
            {
                if(i==m-1 || j==n-1)
                {
                    dp[i][j] = 1;
                    continue;
                }
                else
                {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
};
