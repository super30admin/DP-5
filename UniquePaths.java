package DP5;
//Time complexity : O(mxn) as we are calculating min for each element
//Space complexity: O(mxn)

public class UniquePaths {
    Integer[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new Integer[m][n];
        memo[m-1][n-1] = 1;
        helper(m, n, 0, 0);
        return memo[0][0];
    }
    private int helper(int m, int n, int i, int j){
        if(i>= m || j >= n)
            return 0;
        if(memo[i][j] != null)
            return memo[i][j];
        memo[i][j] = helper(m, n, i+1, j) + helper(m, n, i, j+1);
        return memo[i][j];
    }
}
