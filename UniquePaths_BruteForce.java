// Time Complexity : O(2^mn), m = number of rows, n = number of columns
// Space Complexity : O(m*n), m = number of rows, n = number of columns
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        
        return helper(0,0,m,n);
    }
    private int helper(int i, int j, int m, int n) {
        //base case
        if(i == m || j == n) return 0;
        if(i == m-1 && j == n-1) return 1;
        
        return helper(i+1, j, m, n) + helper(i, j+1, m, n);
    }
}