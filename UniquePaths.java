/* 62. Unique Paths - MEDIUM
https://leetcode.com/problems/unique-paths/

Approach: As the robot can only move down and right, it can reach point (i,j) from one of 2 places,
(i-1, j) or (i, j-1), both of which will be unique. Thus the number of unique paths is the sum of 
unique paths from top and left position.
For the first row and first column, there is only 1 unique path for every cell, from the left and top, repectively.

TC: O(mn) - loop thru the matrix
SC: O(mn) - for dp array
*/

public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int unique[][] = new int[m][n];
        
        // first row and first column --> only 1 unique path
        // rest -> top + left
        // answer at bottom-rigth cell        
        
        for (int i = 0; i < n; i++) {
            unique[0][i] = 1;
        }
        
        for (int i = 0; i < m; i++) {
            unique[i][0] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                unique[i][j] = unique[i-1][j] + unique[i][j-1];
            }
        }
        
        return unique[m-1][n-1];
    }

    public static void main(String args[]) {
        System.out.println(uniquePaths(3,3));
    }
}