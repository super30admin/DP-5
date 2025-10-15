// Time complexity - O(m*n),m = number of rows, n = number of columns
// Space complexity - O(n)
function uniquePaths(m: number, n: number): number {
	const dp = Array.from({ length: n }, () => 0);

	for (let i = 0; i < m; i++) {
		for (let j = 0; j < n; j++) {
			// set max ways oe for right most column and bottom row
			if (i == 0 || j == 0) {
				dp[j] = 1;
			} else {
				// count max ways from right and botton cell
				dp[j] = dp[j - 1] + dp[j];
			}
		}
	}
	return dp[n - 1];
}
