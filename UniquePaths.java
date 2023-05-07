/*
Time complexity - O(m * n) 
Space complexity - O(n)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[] nPaths = new int[n];

        for(int row = m - 1; row >= 0; row--) 
            for(int col = n - 1; col >= 0; col--) 
                if(row == m - 1 || col == n - 1)
                    nPaths[col] = 1;
                else
                    nPaths[col] = dp[col + 1] + dp[col] ;
        return nPaths[0];
    }
}
