package week9.day2;
//Recursion and memoization - Top down dp

class Solution26 {
	int[][] memo;

	public int uniquePaths(int m, int n) {
		memo = new int[m][n];
		return helper(0, 0, m, n);
	}

	private int helper(int r, int c, int m, int n) {
		// base condition
		if (r == m || c == n)
			return 0;
		if (r == m - 1 && c == n - 1)
			return 1;
		if (memo[r][c] != 0)
			return memo[r][c];
		
		// logic
		int case1 = helper(r + 1, c, m, n);
		int case2 = helper(r, c + 1, m, n);
		
		memo[r][c] = case1 + case2;
		
		return memo[r][c];
	}
}

public class UniquePaths_Memoization {

	public static void main(String[] args) {
		Solution26 ob = new Solution26();
		System.out.println(ob.uniquePaths(2, 2));

	}

}
