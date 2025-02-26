/*
TC : O(m*n)
SC : O(m*n)
*/
class Solution
{
public:
    int uniquePaths(int m, int n)
    {
        if (m == 0 && n == 0)
        {
            return 0;
        }

        vector<vector<int>> dp(m + 1, vector<int>(n + 1));
        dp[m - 1][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--)
        {
            for (int j = n - 1; j >= 0; j--)
            {
                if (i == m - 1 && j == n - 1)
                {
                    continue;
                }
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }

        return dp[0][0];
    }
};