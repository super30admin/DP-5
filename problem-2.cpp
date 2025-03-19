// https://leetcode.com/problems/unique-paths/description/

// Recurssion:
// Time Complexity: O(2^(m+n))
// Space Complexity: O(m + n)

class Solution {
    public:
        int uniquePaths(int m, int n) {
            return helper(0,0,m,n);
        }
        int helper(int i, int j, int m, int n){
            if(i == m || j == n) return 0;
            if(i == m-1 || j == n-1) return 1;
    
            int bottom = helper(i+1, j, m, n);
            int right = helper(i, j+1, m, n);
    
            return bottom + right;
    
        }
    };

// dp - memoization
// Time Complexity: O(m × n)
// Space Complexity: O(m × n)

    class Solution {
        public:
            int uniquePaths(int m, int n) {
                vector<vector<int>> dp(m, vector<int>(n,-1));
                return helper(0,0,m,n,dp);
            }
            int helper(int i, int j, int m, int n, vector<vector<int>> &dp){
                if(i == m || j == n) return 0;
                if(i == m-1 || j == n-1) return 1;
                if(dp[i][j] != -1) return dp[i][j];
                int bottom = helper(i+1, j, m, n, dp);
                int right = helper(i, j+1, m, n, dp);
        
                return dp[i][j] = bottom + right;
        
            }
        };
// dp - tabulation
// Time Complexity: O(m × n)
// Space Complexity: O(m × n)

class Solution {
    public:
        int uniquePaths(int m, int n) {
            vector<vector<int>> dp(m, vector<int>(n,1));
            for(int i=1; i<m; i++){
                for(int j=1; j<n; j++){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            return dp[m-1][n-1];
        }
    };

// Optimized dp - tabulation
// Time Complexity: O(m × n)
// Space Complexity: O(n)

class Solution {
    public:
        int uniquePaths(int m, int n) {
            vector<int> prev(n,1);
            for(int i=1; i<m; i++){
                vector<int> curr(n,1);
                for(int j=1; j<n; j++){
                    curr[j] = prev[j] + curr[j-1];
                }
                prev = curr;
            }
            return prev[n-1];
        }
    };