package dp5;

import java.util.Arrays;

public class UniquePaths {
	//Time Complexity : O(m*n)
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for(int i=m-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        
        return dp[0];
    }
	
	//Time Complexity : O(m*n)
	//Space Complexity : O(m*n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(i == m-1 || j == n-1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        
        return dp[0][0];
    }
	
	//Time Complexity : O(m*n)
	//Space Complexity : O(m*n), for memo
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	int[][] memo;
    public int uniquePaths2(int m, int n) {
        memo = new int[m][n];
        memo[m-1][n-1] = 1;
        return dfs2(0, 0, m, n);
    }
    
    private int dfs2(int i, int j, int m, int n) {
        // base
        if(i == m - 1 || j == n - 1)
            return 1;
        
        // logic
        if(memo[i][j] != 0)
            return memo[i][j];
        memo[i][j] = dfs(i + 1, j, m ,n) + dfs(i, j + 1, m, n);
        return memo[i][j];
    }
	
	//Time Complexity : O(2^(m*n))
	//Space Complexity : O(Max(m, n)), for recursion stack
	//Did this code successfully run on Leetcode : TLE
	//Any problem you faced while coding this : No
	public int uniquePaths3(int m, int n) {
        return dfs(0, 0, m, n);
    }
    
    private int dfs(int i, int j, int m, int n) {
        // base
        if(i == m - 1 || j == n - 1)
            return 1;
        
        // logic
        return dfs(i + 1, j, m ,n) + dfs(i, j + 1, m, n);
    }
}
