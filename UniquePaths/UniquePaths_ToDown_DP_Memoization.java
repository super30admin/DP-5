/* Time Complexity : O(m*n) 
 *  m - no. of grid rows
 *  n - no. of grid cols */
/* Space Complexity : O(m+n) + O(h)
 * h - height of the recursive stack */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


//Top Down DP - Memoization
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return helper(0, 0, m, n, memo);
    }

    private int helper(int i, int j, int m, int n, int[][] memo){
        //base condition
        if(i == m || j == n) return 0;
        if(i == m - 1 && j == n - 1) return 1;
        //logic
        //From each grid cell we have two options to go right or bottom, so either row increments by 1 or column increments by 1
        //Using memoisation, storing the value for a grid cell in memo array to avoid duplicate recursive call
        int case1 = 0;
        if(i < m -1){
            if(memo[i+1][j] == 0){
                memo[i+1][j] = helper(i + 1, j, m, n, memo);            
            }
            case1 = memo[i+1][j];
        }
        int case2 = 0;
        if(j < n-1){
            if(memo[i][j+1] == 0){
                memo[i][j+1] = helper(i, j + 1, m, n, memo);
            }
            case2 = memo[i][j+1];
        }
        return case1 + case2;
    }
}

/*

/* Time Complexity : O(m*n) 
 *  m - no. of grid rows
 *  n - no. of grid cols */
/* Space Complexity : O(m+n)
 * height of the recursive stack */

//Top Down DP - Memoization
/*

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return helper(0, 0, m, n, memo);
    }

    private int helper(int i, int j, int m, int n, int[][] memo){
        //base condition
        if(i == m || j == n) return 0;
        if(i == m - 1 && j == n - 1) return 1;
        if(memo[i][j] != 0) return memo[i][j];
        //logic
        //From each grid cell we have two options to go right or bottom, so either row increments by 1 or column increments by 1
        //Using memoisation, storing the value for a grid cell in memo array to avoid duplicate recursive call
        memo[i][j] = helper(i+1, j, m, n, memo) + helper(i, j+1, m, n, memo);
        return memo[i][j];
    }
}

*/