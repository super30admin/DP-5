// Approach -1 - DP
// Time complexity - O(n^2)
// Space complexity - O(n)
// Tested in leetcode
class UniquePaths {
    public int uniquePaths(int m, int n) {
        // space to store results of subproblem
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        
        // path at any path at (i,j) = path at (i,j-1) + path at(i-1,j)
        for(int i=1; i<m; i++){
            for(int j=1;j<n; j++){
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
        
    }
}