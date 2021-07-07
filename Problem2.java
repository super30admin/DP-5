// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. If any of row or column is 1 then there is only one way.So for a grid of 1X1 there is only one way.For 1X2 one way and 
// for 2X1 also one way . FOR 2X2 it is sum of ways for 1X2 and ways for 2X1 .Similarly  For 3X3 it is sum of 3X2 and 2X3.
// 2. Have a 2d array of size mXn  to store values .For first row and first column all values will be 1 . Start from 2nd row ,2nd column. From here
//    each value will sum of ARRAY[i-1][j]+ARRAY[i][j-1]. update all values accordingly till mXn. 
class Solution {
    public int uniquePaths(int m, int n) {
        if( m == 0 || n == 0)   return 0;
        if(m == 1 || n == 1)    return 1;
        
        int[][] dp = new int[m][n];
        for(int i = 0;i<dp.length;i++)
            dp[i][0] = 1;
        for(int j = 0;j<dp[0].length;j++)
            dp[0][j] = 1;
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    
    // recursive solution
    public int uniquePaths2(int m, int n) {
        if( m == 0 || n == 0)   return 0;
        if(m == 1 || n == 1)    return 1;
        return (uniquePaths(m-1,n)+uniquePaths(m,n-1));
    }
}
