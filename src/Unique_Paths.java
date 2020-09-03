/*************************************************Brute Force****************************************/
//Time Complexity : O(2^ m *n), as 2 choices for each cell
//Space Complexity : O(m * n)
//Did this code successfully run on Leetcode : Time Limit Exceeded
//Any problem you faced while coding this : none

class Unique_Paths_Brute_Force {
	public int uniquePaths(int m, int n) {
		if (m == 1 || n == 1) return 1;
		return uniquePaths(m-1, n) + uniquePaths(m, n-1);
	}
}

/*************************************************Brute Force****************************************/
//Time Complexity :  O(2^ m *n), as 2 choices for each cell
//Space Complexity : O(m * n)
//Did this code successfully run on Leetcode : Time Limit Exceeded
//Any problem you faced while coding this : none

class Unique_Paths_Brute_Force_Brute {
	public int uniquePaths(int m, int n) {
		return helper(0, 0, m, n);
	}
	private int helper(int i, int j, int m, int n){
		if(i == m-1 || j == n-1) // if reached last index
			return 1;
		if(i >= m || j>= n)
			return 0;
		//logic
		int right = helper(i+1,j, m, n);
		int down = helper(i, j+1, m , n);

		return right + down;
	}
}

/*************************************************Dynamic Programming****************************************/
//Time Complexity : O(m * n)
//Space Complexity : O(m * n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : none


class Solution {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n]; //dp matrix
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(i == 0 || j == 0)
					dp[i][j] = 1;   // for first row and col fill it with 1

				else
					dp[i][j] = dp[i-1][j] + dp[i][j-1]; // add prev col value with prev row val
			}
		}
		return dp[m-1][n-1];    // return last cell value
	}
}