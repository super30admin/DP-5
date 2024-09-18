// Time Complexity : O(m*n)
// Space Complexity : O(n) -> dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approachs
// Dp -> bottom up approach, fill right and down columns with 1 
// -> one can do down in right most column and only can go right in down most row
// calculate number of paths by adding number of ways of right cell and down cell

class Solution {

    private int dpSolution(int m, int n){
        int dp[] = new int[n];
        Arrays.fill(dp,1); //O(n)

        for(int i=m-2;i>=0;i--)
            for(int j=n-2;j>=0;j--){
                dp[j] = dp[j]+dp[j+1];
            }
        
        return dp[0];
    }

    //Memoization solution
    // Either 1 or 2 should be fine
    // recursively call for all cells of the matrix
    // return value if already calculated
    // Still O(m*n) since each cell is calculated only once
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        memo[m-1][n-1] = 1; //1
        return helper(0,0,m,n,memo);
    }

    private int helper(int i, int j, int m, int n, int[][] memo){
        if(i==m || j==n) return 0;
        if(i==m-1 || j==n-1) return 1; //2 
        if(memo[i][j] !=0 ) return memo[i][j];

        int caseR = helper(i+1, j, m, n, memo);
        int caseD = helper(i, j+1, m, n, memo);
        memo[i][j] = caseR + caseD;
        return memo[i][j];
    }
}