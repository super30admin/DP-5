/**
## Problem 
m * n grid 
target

## constraints & assumptions
- 1 <= m 
- n <= 100

## Test cases
m = 2
n = 3

s 1 1
1 2 3 

ouput = 3

## Approach

2 * O(m*n)

**/

class Solution {
    public int uniquePaths(int m, int n) {
        
        final int dp[][] = new int[m + 1][n + 1];
        
        for (int i=1; i<=m; i++)
        {
            for (int j=1; j<=n; j++)
            {
                if (i==1 && j != 1)
                {
                    dp[i][j] = dp[i][j-1];
                }
                else if (i!= 1 && j == 1)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else if (i != 1 && j != 1)
                {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
                else
                {
                    dp[i][j] = 1;
                }
            }
        }
        
        return dp[m][n];
    }
}
