// Time Complexity : O(m*n) where m = number of rows, n = number of columns
// Space Complexity : O(min(m*n)) where m = number of rows, n = number of columns
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//62. Unique Paths (Medium) - https://leetcode.com/problems/unique-paths/
// Time Complexity : O(2 power m*n)
// Space Complexity : O(h) where h = height of tree
//class Solution {
//    public int uniquePaths(int m, int n) {
//        return helper(0, 0, m, n);
//    }
//    
//    private int helper(int i, int j, int m, int n) {
//        // base
//        if (i == m || j == n) return 0;
//        if (i == m-1 && j == n-1) return 1;
//        
//        // logic
//        // case 1
//        int case1 = helper(i+1, j, m, n);
//        
//        // case 2
//        int case2 = helper(i, j+1, m, n);
//        
//        return case1 + case2;
//    }
//}

// Time Complexity : O(m*n) where m = number of rows, n = number of columns
// Space Complexity : O(m*n) where m = number of rows, n = number of columns
//class Solution {
//    
//    int[][] memo;
//    
//    public int uniquePaths(int m, int n) {
//        memo = new int[m][n];
//        return helper(0, 0, m, n);
//    }
//    
//    private int helper(int i, int j, int m, int n) {
//        // base
//        if (i == m-1 && j == n-1) return 1;
//        
//        // logic
//        // case 1
//        int case1 = 0;
//        if (i < m-1) {
//            if (memo[i+1][j] == 0) {
//                memo[i+1][j] = helper(i+1, j, m, n);
//            }
//            case1 = memo[i+1][j];
//        }
//        
//        // case 2
//        int case2 = 0;
//        if (j < n-1) {
//            if (memo[i][j+1] == 0) {
//                memo[i][j+1] = helper(i, j+1, m, n);
//            }
//            case2 = memo[i][j+1];
//        }
//        
//        return case1 + case2;
//    }
//}

// Time Complexity : O(m*n) where m = number of rows, n = number of columns
// Space Complxity : O(m*n) where m = number of rows, n = number of columns
//class Solution {
//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        
//        for (int j = 0; j < n; j++) { // filling last row of each column with 1's
//            dp[m-1][j] = 1;
//        }
//        
//        for (int i = 0; i < m; i++) { // filling last column of each row with 1's
//            dp[i][n-1] = 1;
//        }
//        
//        for (int i = m-2; i >= 0; i--) {
//            for (int j = n-2; j >= 0; j--) {
//                dp[i][j] = dp[i+1][j] + dp[i][j+1];
//            }
//        }
//        
//        return dp[0][0];
//    }
//}

// Time Complexity : O(m*n) where m = number of rows, n = number of columns
// Space Complxity : O(min(m*n)) where m = number of rows, n = number of columns
class Solution {
    public int uniquePaths(int m, int n) {
        if (m < n) return uniquePaths(n, m);
        int[] dp = new int[n];
        
        for (int j = 0; j < n; j++) { // filling last row of each column with 1's
            dp[j] = 1;
        }
        
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                dp[j] = dp[j] + dp[j+1];
            }
        }
        
        return dp[0];
    }
}