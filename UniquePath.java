import java.util.Arrays;


//Time Complexity : O(M*N) for Recursive,Top Down and Bottom Up

//Space Complexity : O(1) for Recursive,O(N^2) for Top Down and Bottom Up
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

public class UniquePath {
	// Recursive Approach
	public int uniquePaths(int m, int n) {
		if (m == 1 || n == 1)
			return 1;
		return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
	}

	// BOttom Down Approach
	public int dp1(int m, int n) {
		int[][] dp = new int[m + 1][n + 1];

		for (int arr[] : dp) {
			Arrays.fill(arr, 1);
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	// Top Up Approach
	public int dp2(int m, int n) {
		int[][] dp = new int[m + 1][n + 1];

		dp[m - 1][n - 1] = 1;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1) {
					continue;
				}
				dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
			}
		}
		return dp[0][0];
	}

	public static void main(String args[]) {
		int m = 4, n = 4;

		UniquePath path = new UniquePath();

		System.out.println(path.uniquePaths(m, n));
		System.out.println(path.dp1(m, n));
		System.out.println(path.dp2(m, n));

	}
}
