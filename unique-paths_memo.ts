// Time complexity - O(m*n),m = number of rows, n = number of columns
// Space complexity - O(m*n)
function uniquePaths(m: number, n: number): number {
	const memo = Array.from({ length: m }, () =>
		Array.from({ length: n }, () => -1)
	);

	return helper(m, n, 0, 0);

	function helper(m: number, n: number, i: number, j: number) {
		// return if we reach the boundry
		if (i == m || j == n) return 0;

		// return if the memo matrix already has value
		if (memo[i][j] != -1) return memo[i][j];

		// for the right most column and bottom row, return 1
		if (i == m - 1 && j == n - 1) {
			return 1;
		}

		// right
		const case0 = helper(m, n, i, j + 1);

		// down
		const case1 = helper(m, n, i + 1, j);

		// store the max ways from right and bottom in memo matrix
		memo[i][j] = case0 + case1;
		return memo[i][j];
	}
}
