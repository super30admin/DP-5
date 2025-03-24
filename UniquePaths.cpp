// Time Complexity: O(m*n)
// Space Complexity: O(m*n)
// Did this code successfully run on Leetcode : Yes

// Approach: 
//1. Start from bottom right and move to top left
//2. At each cell, the number of ways to reach that cell is the sum of the number of ways to reach the cell below it and the cell to the right of it.
//3. Fill the dp array with the number of ways to reach each cell.
//4. Return the value at the top left cell.
 
class Solution {
    vector<vector<int>> dp;
public:
    int uniquePaths(int m, int n) {
        dp = vector<vector<int>>(m + 1, vector<int>(n+1, -1));
        return helper(m, n);
    }
private: 
    int helper(int m, int n){
        // base case
        if(m == 1 && n == 1){
            return 1;
        }
        //out of bounds
        if(m < 1 || n < 1){
            return 0;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        return dp[m][n] = helper(m - 1, n) + helper(m, n - 1);
    }
};