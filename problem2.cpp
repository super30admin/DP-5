
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Approach : Recursion with memoization
// Time Complexity : O(m*n)
// Space Complexity : O(m*n) (max m = 100, max n = 100 in this case)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    int dp[101][101];
    int recurse(int r,int c,int m,int n)
    {
        if(r>=m || c>=n) return dp[r][c]=0;
        if(r==m-1 && c == n-1){
           return dp[r][c] = 1;  
        }
        if(dp[r][c]!=-1) return dp[r][c];
        
        int right = recurse(r,c+1,m,n);
        int down = recurse(r+1,c,m,n);
        return dp[r][c]=(right + down);
    }
    int uniquePaths(int m, int n) {
        memset(dp,-1,sizeof(dp));
        return recurse(0,0,m,n);
    }
};


// Approach : bottom up dp
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes

class Solution {
public:

    int uniquePaths(int m, int n) {
        vector<vector<int>>dp(m,vector<int>(n,1));
        for(int i = m-2;i>=0;i--)
        {
            for(int j = n-2;j>=0;j--)
            {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
};
// Approach : bottom up dp with space optimized
// Time Complexity : O(m*n)
// Space Complexity : O(2*n) 
// Did this code successfully run on Leetcode : yes

class Solution {
public:

    int uniquePaths(int m, int n) {
        vector<vector<int>>dp(2,vector<int>(n,1));
        for(int i = m-2;i>=0;i--)
        {
            for(int j = n-2;j>=0;j--)
            {
                dp[i%2][j] = dp[(i+1)%2][j] + dp[i%2][j+1];
            }
        }
        return dp[0][0];
    }
};
