//Time complexity is O(m*n)
//Space complexity is O(m*n)
//This solution is submitted on leetcode

public class BigN109UniquePathInMatrixDPSolution {
	class Solution {
		public int uniquePaths(int m, int n) {
			// edge case
			if (m == 0 || n == 0)
				return 0;
			int[][] dp = new int[m + 1][n + 1];
			dp[m - 1][n - 1] = 1;
			for (int i = m - 1; i >= 0; i--) {
				for (int j = n - 1; j >= 0; j--) {
					if (i == m - 1 && j == n - 1)
						continue;
					dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
				}
			}
			return dp[0][0];
		}
	}
}