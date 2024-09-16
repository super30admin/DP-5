// Time Complexity : O(m*n), m = number of rows, n = number of columns
// Space Complexity : O(min(m,n)), m = number of rows, n = number of columns
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0)
            return 0;
        if(n > m) return uniquePaths(n, m); //to take the smallest possible array at all times
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i=m-2; i>=0; i--) 
            for(int j=n-2; j>=0; j--) 
                dp[j] = dp[j] + dp[j+1]; 
        
        return dp[0];
    }
}