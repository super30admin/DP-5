// S30 Big N Problem #109 {Medium}
// 62. Unique Paths
// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class Solution {
    public int uniquePaths(int m, int n) {
        int [][]dp=new int[m][n];
        
        
        //left column
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        
        //top row
        for(int j=0;j<n;j++){
            dp[0][j]=1;
        }
        
        //filling the dp matrix
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        
        return dp[m-1][n-1];
    }
}