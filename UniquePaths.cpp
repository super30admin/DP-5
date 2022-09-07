// Approach - DFS
// Time Complexity -> O(2^m*n)
// Space Complexity -> O(1) 
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
    private:
    int helper(int i, int j, int m, int n){
        // base
        if(i == m || j == n)
            return 0;
        if(i == m - 1 && j == n - 1)
            return 1;
        
        // logic
        return helper(i, j+1, m, n) + helper(i+1, j, m, n);
    }
public:
    int uniquePaths(int m, int n) {
        return helper(0, 0, m, n);
    }
};

// Approach - Bottom-up DP
// Time Complexity -> O(m*n)
// Space Complexity -> O(m*n) 
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> dp(m+1, vector<int>(n+1));
        dp[m-1][n-1] = 1;
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(i == m-1 && j == n-1)
                    continue;
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }
};

// Optimised DP on space.
class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<int> dp(n+1);
        dp[n-1] = 1;
        dp[n] = 0;
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                // if(i == m-1 && j == n-1)
                //     continue;
                dp[j] = dp[j+1] + dp[j];
            }
        }
        return dp[0];
    }
};

// Approach - Memoisation
// Time Complexity -> O(m*n)
// Space Complexity -> O(m*n) 
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
    vector<vector<int>> memo;
    private:
    int helper(int i, int j, int m, int n){
        // base
        if(i == m || j == n)
            return 0;
        if(i == m-1 && j == n-1)
            return 1;
        
        // logic
        int right = 0;
        if(memo[i][j+1] == 0)
            memo[i][j+1] = helper(i, j+1, m, n);
        right = memo[i][j+1];
        
        int bottom = 0;
        if(memo[i+1][j] == 0)
            memo[i+1][j] = helper(i+1, j, m, n);
        bottom = memo[i+1][j];
        return bottom + right;
    }
public:
    int uniquePaths(int m, int n) {
        memo.resize(m+1);
        for (int i = 0; i < m+1; ++i)
            memo[i].resize(n+1);
        
        return helper(0, 0, m, n);
    }
};