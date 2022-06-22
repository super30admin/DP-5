// brute force | Time: O(2^MN) | Space: O(M+N) recursive stack

class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0,0,m,n);
    }
    private int helper(int i, int j, int m, int n) {
        if(i==m-1 && j==n-1) return 1;
        if(i==m || j==n) return 0;
        return helper(i+1, j, m, n)+ helper(i, j+1, m, n);
    }
}

// DP soln - |Time: O(MN) | Space: O(MN)
class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i = m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--) {
                if(i==m-1 && j== n-1) continue;
                dp[i][j] = dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}

//DP soln - Same time as above, but space O(N)
class Solution {
    int[] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[n+1];
        dp[n-1] = 1;
        for(int i = m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--) {
                dp[j] = dp[j]+dp[j+1];
            }
        }
        return dp[0];
    }

}