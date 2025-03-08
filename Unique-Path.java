

// Time Complexity : Exponential
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Bruteforce
class Solution {
    public int uniquePaths(int m, int n) {
    
        if (m == 0 && n == 0) {
            return 0;
        }
        
        return recurse(m, n, 0, 0);
    }

    private int recurse(int m, int n, int row, int col) {
       
        if (row == m || col == n) {
            return 0;
        }
       
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
      
        int case1 = recurse(m, n, row, col + 1);
        
        int case2 = recurse(m, n, row + 1, col);
       
        return case1 + case2;
    }
}


// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int uniquePaths(int m, int n) {
       
        if (m == 0 && n == 0) {
            return 0;
        }
       
        int[][] dp = new int[m + 1][n + 1];
       
        dp[m - 1][n - 1] = 1;
       
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
               
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        
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
        
        if (m == 0 && n == 0) {
            return 0;
        }
       
        int[] dp = new int[n];
       
        Arrays.fill(dp, 1);
        
        for (int i = m - 2; i >= 0; i--) {
            
            for (int j = n - 2; j >= 0; j--) {
                
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        
        return dp[0];
    }
}