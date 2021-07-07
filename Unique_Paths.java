TC: O(mn)
SC: O(mn)

Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
Memory Usage: 33 MB, less than 5.10% of Java online submissions for Unique Paths.

Approach: Then number of paths to the right bottom corner is the sum of paths in the top and left positions.Thus it becomes a 
repeated sub problem of finding the sum of paths in each cell's top and left cells.


class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int j=0; j<n;j++){
           dp[0][j] = 1;
        }
        for(int i=0; i<m;i++){
           dp[i][0] = 1;
        }
        for(int i=1; i< m; i++){
            for(int j=1 ; j<n ;j++ ){
                dp[i][j] = dp[i-1][j]+ dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
