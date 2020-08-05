// Time Complexity : O(2 ^ (m*n)) where m & n are lengths of input matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (62): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0, 0, m, n);
    }
    
    private int helper(int i, int j, int m, int n) {
        // base case
        if (i == m-1 && j == n-1) return 1;
        if (i >= m || j >= n) return 0;
        
        // logic
        int right = helper(i, j+1, m, n);
        int down = helper(i+1, j, m, n);
        return right + down;
    }
}