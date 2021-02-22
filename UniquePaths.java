// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class UniquePaths {
    public int uniquePaths(int m, int n) {
        //add one more row/column
        int [][] dp = new int [m+1][n+1];
        //1 at end bc only one possible path
        dp[m-1][n-1] = 1;
        //loop and increment paths as get farther from finish
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                //skip end index
                if(i == m-1 && j == n-1) continue;
                //inc. path value
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        //num of paths from start
        return dp[0][0];
    }
}