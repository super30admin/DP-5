/* Time Complexity : O(2^(m+n)) 
 *  m - no. of grid rows
 *  n - no. of grid cols */
/* Space Complexity : O(h)
 * h - height of the recursive stack */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0, 0, m, n);
    }

    private int helper(int i, int j, int m, int n){
        //base condition
        if(i == m || j == n) return 0;
        if(i == m - 1 && j == n - 1) return 1;
        //logic
        //From each grid cell we have two options to go right or bottom, so either row increments by 1 or column increments by 1
        int case1 = helper(i + 1, j, m, n);
        int case2 = helper(i, j + 1, m, n);
        return case1 + case2;
    }
}