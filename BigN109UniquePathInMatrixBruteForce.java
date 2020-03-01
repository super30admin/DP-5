//Time complexity is O(2^m*n)
//Space complexity is O(m*n)
//This solution is submitted on leetcode

public class BigN109UniquePathInMatrixBruteForce {
	class Solution {
		public int uniquePaths(int m, int n) {
			// edge case
			if (m == 0 || n == 0)
				return 0;
			return helper(0, 0, m, n);

		}

		private int helper(int i, int j, int m, int n) {
			// base case
			if (i >= m || j >= n)
				return 0;
			if (i == m - 1 && j == n - 1)
				return 1;

			// logic
			int right = helper(i, j + 1, m, n);
			int bottom = helper(i + 1, j, m, n);
			return right + bottom;
		}
	}
}