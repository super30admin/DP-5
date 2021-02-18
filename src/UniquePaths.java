/*  The complexity of the algorithm is O(m*n) where  m is no of rows and n is no of column .
 * Space complexity is O(m*n) .
 */

public class UniquePaths {

	// DP solution

	public int uniquePaths1(int m, int n) {

		int[][] dp = new int[m + 1][n + 1];
		dp[m - 1][n - 1] = 1;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {

				if (i == m - 1 && j == n - 1)
					continue;

				dp[i][j] = dp[i + 1][j] + dp[i][j + 1];

			}
		}

		return dp[0][0];
	}

	// recursive approach

	public int uniquePaths(int m, int n) {

		return helper(m, n, 0, 0);

	}

	private int helper(int m, int n, int i, int j) {
		// base
		if (i == m - 1 || j == n - 1)
			return 1;

		if (i == m || j == n)
			return 0;

		return helper(m, n, i + 1, j) + helper(m, n, i, j + 1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
