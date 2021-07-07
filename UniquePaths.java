// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// To reach any specific point, robot needs to know how many unique paths exist to reach its left and top cell.
// As a starting point, when the robot is at (0,0) position, it can go on all cells in current row and current column in just 1 way. 

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] pathTracker = new int[m][n]; 
        for(int i = 0; i < m; i++) {
            pathTracker[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
            pathTracker[0][i] = 1;
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                pathTracker[i][j] = pathTracker[i-1][j] + pathTracker[i][j-1];
            }
        }
        return pathTracker[m-1][n-1];
    }
}

