
public class Unique_Paths {
	//Approach: Dp - Bottom up approach
	//1. Here we start buidling the dp grid with m+1 rows and n+1 columns, hence we mark the finish as 1, and then keep going up by adding values of right and bottom cell. 
	//2. The value we got in the pos 0,0 is the total no of ways we can go to the finish position.
	 public int uniquePaths(int m, int n) {
	        int[][] dp =  new int[m+1][n+1];
	        dp[m-1][n-1] = 1;
	        for(int i=m-1; i >=0 ;i--)
	        {
	            for(int j=n-1;j>=0;j--)
	            {
	                if(i == m-1 && j == n-1)continue;
	                dp[i][j] = dp[i+1][j] + dp[i][j+1];
	            }
	        }
	        return dp[0][0];
	    }
}
//Time Complexity : O(mn) 
//Space Complexity : O(mn) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :