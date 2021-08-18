// Time Complexity : O(m * n), m -> Number of rows, n -> Number of columns
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.Arrays;

public class UniquePaths {
	/********************* Brute Force *********************/
	// Time Complexity : O(2^(m * n)), m -> Number of rows, n -> Number of columns
	// Space Complexity : O(m * n), Recursive Stack
	// Did this code successfully run on Leetcode : Time Limit Exceeded
	// Any problem you faced while coding this : No
	public int uniquePathsBruteForce(int m, int n) {
		if (m == 0 && n == 0) {
			return 0;
		}

		if (m == 1 && n == 1) {
			return 1;
		}

		return helper(0, 0, m, n);
	}

	private int helper(int i, int j, int m, int n) {
		// Base Case
		if (i == m || j == n) {
			return 0;
		}

		if (i == m - 1 && j == n - 1) {
			return 1;
		}
		// Logic
		return helper(i + 1, j, m, n) + helper(i, j + 1, m, n);
	}

	/********************* Dynamic Programming *********************/
	// Time Complexity : O(m * n), m -> Number of rows, n -> Number of columns
	// Space Complexity : O(m * n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No\
	public int uniquePathsDP(int m, int n) {
		if (m == 0 && n == 0) {
			return 0;
		}

		if (m == 1 && n == 1) {
			return 1;
		}

		int[][] dp = new int[m][n];

		for (int i = m - 1; i >= 0; i--) {
			dp[i][n - 1] = 1;
		}

		for (int j = n - 1; j >= 0; j--) {
			dp[m - 1][j] = 1;
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
			}
		}

		return dp[0][0];
	}

	/********************* Optimized Dynamic Programming 1 *********************/
	// Time Complexity : O(m * n), m -> Number of rows, n -> Number of columns
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int uniquePathsOptimizedDB(int m, int n) {
		if (m == 0 && n == 0) {
			return 0;
		}

		if (m == 1 && n == 1) {
			return 1;
		}

		if (n > m) {
			return uniquePaths(n, m);
		}

		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int right;

		for (int i = m - 2; i >= 0; i--) {
			right = 0;
			for (int j = n - 1; j >= 0; j--) {
				dp[j] = dp[j] + right;
				right = dp[j];
			}
		}

		return dp[0];
	}

	/********************* Optimized Dynamic Programming 1 *********************/
	// Time Complexity : O(m * n), m -> Number of rows, n -> Number of columns
	// Space Complexity : O(n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public int uniquePaths(int m, int n) {
		if (m == 0 && n == 0) {
			return 0;
		}

		if (m == 1 && n == 1) {
			return 1;
		}

		if (n > m) {
			return uniquePaths(n, m);
		}

		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				dp[j] += dp[j + 1];
			}
		}
		return dp[0];
	}

	public static void main(String[] args) {
		UniquePaths obj = new UniquePaths();
		int m = 5;
		int n = 7;

		System.out.println("Number of unique paths to reach the bottom right corner of a " + m + " x " + n + " matrix: "
				+ obj.uniquePaths(m, n));
	}

}
