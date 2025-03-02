// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Unique Paths
// Approach: Dynamic Programming (Space Optimization)
// Time Complexity: O(M * N)
// Space Complexity: O(N)

class Solution {
    public:
        int uniquePaths(int m, int n) {
            if (m == 0 || n == 0) {
                return 0;
            }
    
            vector<int> dp(n, 1);  
            for (int i = m - 2; i >= 0; i--) {  
                for (int j = n - 2; j >= 0; j--) { 
                    dp[j] = dp[j + 1] + dp[j];  
                }
            }
    
            return dp[0];  
        }
    };
    