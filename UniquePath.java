// Time Complexity : O(m+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Initialization: Create a 1D array dp of size n filled with 1s to represent the number of unique paths to the last row.
//Dynamic Programming: Iterate from bottom to top and right to left, updating dp[j] as the sum of the current cell and the cell to its right.
//Result: Return dp[0], which contains the number of unique paths from the top-left to the bottom-right of the grid.

class Solution {
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0){
            return 1;
        }
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        for(int i = m-2; i>=0; i--){
            for(int j = n-2; j>=0;j--){
                dp[j] = dp[j]+dp[j+1];
            }
        }
        return dp[0];
    }
}