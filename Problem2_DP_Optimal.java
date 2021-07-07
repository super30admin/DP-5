/**
LeetCode Submitted : No (Time Limit Error)
Time Complexity : O(M*N)
Space Complexity : O(M*N)

The idea is to store the previous traverse path in bottom up fashion by storing the possible number of paths in the grid. WE know that there is only one way to reach end of grid from position m-1 and n-1. So, at each new position we find the sum of possible path from right cell and bottom cell till we reach start of the grid. At the end, we will return value at position [0][0]. For this we will create a DP array of one extra row and column to handle boundary cases easily.

**/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        
        dp[m-1][n-1] = 1;
        
        for(int i = m-1; i>=0; i--){
            for(int j =n-1;j>=0;j--){
                if(i == m-1 && j == n-1)
                    continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
                
            }
        }
        
        
        return dp[0][0];
        
    }
}
