//Brute Force
//TC - O(2^(m^2 + n^2))
//SC - O(1)
//TLE on Leetcode

class Solution {
    int paths = 0;
    public int uniquePaths(int m, int n) {
        findpaths(m, n, 0, 0);
        return paths;
    }
    
    private void findpaths(int m, int n, int x, int y)
    {
        //base
        if(x == m || y == n) return;
        
        if(x == m -1 && y == n - 1)
        {
            ++paths;
            return;
        }
        
        //logic
        findpaths(m, n, x + 1, y);
        findpaths(m, n , x, y + 1);
    }
}



//DP Solution
//TC - O(mn)
//SC - O(mn)
//Ran Successfully on leetcode

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; ++i)
            dp[i][0] = 1;
        
        for(int j = 0; j < n; ++j)
            dp[0][j] = 1;
        
        for(int i = 1; i < m; ++i)
        {
            for(int j = 1; j < n; ++j)
            {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
}
