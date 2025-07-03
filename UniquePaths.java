/* Approach- Create a new dp array with m rows and n columns. 
Iterate through each row and column and add the top and left element and assign it as the value to the current element if both row and column are greater than 0. 
Else simply assign 1. The last element of the matrix will have the total number of unique ways.
*/

//Time Complexity: O(m * n)
//Space Complexity: O(m * n)

//LeetCode: https://leetcode.com/problems/unique-paths/

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 || col == 0) {
                    ans[row][col] = 1;
                }
                else {
                    ans[row][col] = ans[row-1][col] + ans[row][col - 1];
                }
            }
        }
        return ans[m-1][n-1];
    }
    
}
