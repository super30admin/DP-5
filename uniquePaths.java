/*
Problem: https://leetcode.com/problems/unique-paths/
*/

// Approach 1: Brute Force - TLE
// TC: O(2^(m*n))
class Solution {
    public int uniquePaths(int m, int n) {
        return traverse(0, 0, m, n);
    }
    
    private int traverse(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        
        if (i == m || j == n) {
            return 0;
        }
        
        int right = traverse(i, j + 1, m, n);
        int down = traverse(i + 1, j, m, n);
        return right + down;
    }
}

// Approach 2: DP
// TC: O(m * n)
// SC: O(m * n)
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        
        for (int i = 0; i < n; ++i) {
            dp[0][i] = 1;
        }
        
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        
        return dp[m-1][n-1];
    }
}
// Can do the same thing by filling the bottom row and last column with 1s and starting from bottom right
// Answer will be in dp[0][0]

// Approach 3: Space optimized
// TC: O(m * n)
// SC: O(n)
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[] = new int[n];
        
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
        }
        
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[j] = dp[j-1] + dp[j];
            }
        }
        
        return dp[n-1];
    }
}