// Time Complexity : O(m x m)
// Space Complexity : O(m x n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach: fill the dp array which will contain the number of unique ways to get to that cell

public class UniquePaths{
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int[] arr:dp){
            Arrays.fill(arr,1);
        }
        for(int col = 1; col<m; col++)
            for(int row = 1; row<n; row++)
                dp[col][row] = dp[col-1][row] + dp[col][row-1];
        return dp[m-1][n-1];
    }
}