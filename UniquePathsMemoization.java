// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/unique-paths/
// Any problem you faced while coding this : No

// This is a solution for Top-Down approach.
class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        this.memo= new int[m][n];
        return helper(m,n,0,0);
    }

    public int helper(int m, int n, int r, int c){
        //basic
        if(r==m|| c==n) return 0;
        if(r==m-1||c==n-1) return 1;
        if(memo[r][c]!=0){
            return memo[r][c];
        }
        //logic
        int caseR = helper(m,n,r,c+1);
        int caseB = helper(m,n,r+1,c);
        memo[r][c] = caseR+caseB; 
        return memo[r][c]; 
    }
}
