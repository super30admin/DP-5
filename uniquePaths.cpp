// Time Complexity : O(m * n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Build DP array to store unique paths from current cell. DP array stores only the one row values.
 * Start iterating over grid from end of the grid. 
 * For each cell compute the unique paths by adding right cell value and bottom cell value.
 * At the end return the value computed for starting cell. 
 */

class Solution {
public:
    int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        
        int dp[n];
        
        for (int i = 0; i < n; i++)
        {
            dp[i] = 1;
            
        }
        
        for (int i = m - 2; i >= 0; i--)
        {
            for (int j = n - 2; j >= 0; j--)
            {
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        return dp[0];
    }
    
};