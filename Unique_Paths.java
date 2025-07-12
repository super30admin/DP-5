// Time complexity - O(m*n)
// Space - Complexity - O(m*n)
// Solved on leetcode - yes
// faced any issues - No
// Solving the problem using DP top down memorization
class Solution {
    int memo[][];
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                memo[i][j] = -1;
            }
        }
        return helper(m,n,0,0);
    }
    public int helper(int m, int n, int i, int j) {
        if(i == m || j== n) return 0;
        if(i == m-1 && j== n-1) {
            return 1;
        }
        if(memo[i][j] == -1) {
            memo[i][j] = helper(m,n,i+1,j) + helper(m, n,i, j+1);
        }
        return memo[i][j];
    }
}
