//Time complexity : O(m * n)
//Space complexity : O(n)

//Approach : 
            // Build a bottom up dp matrix
            // As robot can only move bottom or right, we only need consider these two cells of every cell to calculate path

class Solution {
public:
    int uniquePaths(int m, int n) {
        if(m == 0)
            return 1;
        
//         vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        
//         dp[m-1][n-1] = 1;
//         for(int i =  m - 1; i >= 0  ; i--)
//         {
//             for(int j = n - 1 ; j >= 0 ; j--)
//             {
//                 dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
//             }
//         }
        
        vector<int> dp(n, 1);
        
        for(int i = m - 2; i >= 0; i--)
        {
            for(int j = n - 2 ; j >= 0 ; j--)
            {
                dp[j] += dp[j + 1];
            }
        }
        
        return dp[0];
    }
};