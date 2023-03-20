//Time Complexity : O(N^2) 
//Space Complexity : O(N^2) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Fill the last cell as 1 because there is one path from last cell to itself.
 * And for all cells from last row and col will also have only 1 path. So start
 * from m-2, n-2th cell and calculate number of paths possible from there. It is
 * just adding right and down cells. return 0,0 cell value as the answer.
 *
 */
class Solution {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		dp[m - 1][n - 1] = 1;
		for (int i = 0; i < m; i++)
			dp[i][n - 1] = 1;
		for (int j = 0; j < n; j++)
			dp[m - 1][j] = 1;

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
			}
		}
		return dp[0][0];
	}
}
