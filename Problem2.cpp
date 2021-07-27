// Time Complexity : O(m x n) optimal
// Space Complexity : O(n) optimal
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Unique Paths

#include<iostream>
#include<vector>

using namespace std;

// Brute force O(2^(m x n))

class Solution {
public:
    int uniquePaths(int m, int n) {
        
        if(m == 0 && n == 0)
            return 0;
        
        return helper(0, 0, m, n); // start from top
        
    }
    
    int helper(int i, int j, int row, int col){
        
        // base
        if(i == row || j == col)
            return 0;
        
        if(i == row - 1 && j == col - 1)
            return 1;
        
        //  logic
        return helper(i + 1, j, row, col) + helper(i , j + 1, row, col);    // right and down are two different moves hence two different calls 
        
    }
};


// DP O(m x n) Time and Space

class Solution {
public:
    int uniquePaths(int m, int n) {
        
        if(m == 0 || n == 0)
            return 0;
        
        vector<vector<int>> dp(m + 1, vector<int>(n + 1,0));
        
        dp[m-1][n-1] = 1;
        
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if( i == m - 1 && j == n - 1)
                    continue;
                
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        
        return dp[0][0];
    }
};


// DP O(n) Space

class Solution {
public:
    int uniquePaths(int m, int n) {
        
        vector<int> dp(n+1,1);
        int right;
        dp[n] = 0;
        for(int i = m-2; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                right = dp[j];
                dp[j] = dp[j+1] + right;
            }
        }
        return dp[0];
    }
};