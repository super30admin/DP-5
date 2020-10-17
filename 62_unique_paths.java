    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/unique-paths/
    Time Complexity for operators : o(n*m) .. n is the length of the string
    Extra Space Complexity for operators : o(n*m) .. n for dp array and m for hashset
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Two for loops and find the minimum window that has string. o(n*2) time complexity
        # Optimized approach: 
                              
            # 1. 
                    A) Create An DP matrix with 1 added in first row and first column.
                    B) Then, two for loops and create the matrix. by summing upper and left column.
                    C) At the end, return last block.
    */ 

class Solution {
    public int uniquePaths(int m, int n) {
        
        // time limit exceeded for this
    //         if (m == 1 || n == 1) {
    //   return 1;
    // }
    // return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        
        
        // DP solution for it
        
        int dp[][] = new int[m][n];
        
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        
        for(int i=0;i<n;i++){
            dp[0][i] = 1;
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
}