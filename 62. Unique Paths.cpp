/*
Time: O(m*n)
Space: O(m*n)

Cell (0,0) can be reached by 1 way.
Every other cell (i,j) can be reached from cell (i-1,j) and cell (i,j-1) (if they are inside grid)
So for paths for cell(i,j) = paths for cell (i-1,j) + paths for cell (i,j-1)
*/

class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> dp(m,vector(n,0));
        dp[0][0] = 1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>0)  dp[i][j] += dp[i-1][j];
                if(j>0)  dp[i][j] += dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
};
