// In this problem, for any cell, calculating the unique ways to reach to the destination from cell to the right of it and from cell
// to the bottom of it. Adding both ways to get the total ways for that cell. Make recursive call for each cell.

// Time Complexity : Exponential
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Bruteforce
class Solution {
    public int uniquePaths(int m, int n) {
        // Base
        if (m == 0 && n == 0) {
            return 0;
        }
        // Make the recursive call
        return recurse(m, n, 0, 0);
    }

    private int recurse(int m, int n, int row, int col) {
        // Base Case
        if (row == m || col == n) {
            return 0;
        }
        // If the row and col is the index of destination cell, then we are already at
        // that position so just 1 way, so return 1
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        // Logic
        // Case 1: Robot moves right
        int case1 = recurse(m, n, row, col + 1);
        // Case 2: Robot moves downward
        int case2 = recurse(m, n, row + 1, col);
        // Return total ways from both the case
        return case1 + case2;
    }
}

// Using dp matrix:
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int uniquePaths(int m, int n) {
        // Base case
        if (m == 0 && n == 0) {
            return 0;
        }
        // Declare dp matrix with one dummy row and dummy col for filling the cells at
        // m-1 row and n-1 col
        int[][] dp = new int[m + 1][n + 1];
        // We know that when we are at the destination then 1 way, so set it 1
        dp[m - 1][n - 1] = 1;
        // Start iterating from m-1 row and n-1 col
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // If it is our destination cell, we already set it to 1, so skip
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
                // Else, answer for any cell is the sum of cell to the right of it and cell to
                // the bottom of it
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        // Final answer lies in first row and first cell
        return dp[0][0];
    }
}

// Using single dp row:
// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int uniquePaths(int m, int n) {
        // Base
        if (m == 0 && n == 0) {
            return 0;
        }
        // Declare the dp row of size n
        int[] dp = new int[n];
        // We know that m-1 row will have all 1, since there is only one way to reach,
        // right->right->right...
        // So fill it with 1
        Arrays.fill(dp, 1);
        // Start from m-2 row
        for (int i = m - 2; i >= 0; i--) {
            // We also know that n-1 column also have values 1, since only one way,
            // down->down->...
            // So start from n-2 column, therefore on right there will always be value 1
            // for the start
            for (int j = n - 2; j >= 0; j--) {
                // For any cell, the right value lies on the cell j+1, and the bottom value is
                // the old value present at same position
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        // Our answer lies at the first cell
        return dp[0];
    }
}