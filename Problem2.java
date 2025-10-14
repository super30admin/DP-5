/*
62. Unique Paths
Ran on leetcode: Yes
TC: O(m * n) 
SC: O(m * n) 
Find total number of paths on right and down recursively and add them and return the result. While recursively exploring them also store the total number of paths calculated for each record.
*/
class Solution {

    private Integer[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new Integer[m][n];
        int result = helper(m, n, 0, 0);
        return result;
    }

    private int helper(int m, int n, int i, int j){
        
        // base case
        if(i == m || j == n){ // Out of bounds check
            return 0;
        }

        if(memo[i][j] != null){ // Check the memo matrix and return
            return memo[i][j];
        }


        if(i == m - 1 && j == n - 1){ // Reached target
            return 1;
        }


        int case0 = helper(m, n, i + 1, j); // Move down
        int case1 = helper(m, n, i, j + 1); //Move right

        int res = case0 + case1;
        
        // store the result
        memo[i][j] = res;

        return res;
    }
}