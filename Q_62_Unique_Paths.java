package Q_62_Unique_Paths;

//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//How many possible unique paths are there?
//
//
//Above is a 7 x 3 grid. How many possible unique paths are there?
//
//Note: m and n will be at most 100.
//
//Example 1:
//
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//1. Right -> Right -> Down
//2. Right -> Down -> Right
//3. Down -> Right -> Right
//Example 2:
//
//Input: m = 7, n = 3
//Output: 28

//Time Complexity  : O(m*n)
//Space Complexity : O(m*n)

public class Solution {
	public int uniquePaths(int m, int n) {
		int dp[][] = new int[m+1][n+1];
		dp[m-1][n-1] =1;
		for(int i= m-1;i>=0;i--) {
			for(int j = n-1;j>=0;j--) {
				if(i == m-1 && j == n-1) {
					continue;
				}
				
				dp[i][j] = dp[i][j+1] + dp[i+1][j];
			}
		}
		return dp[0][0];
	}
	
	public int helper(int i, int j, int m, int n) {
		if(i >= m || j >=n) {
			return 0;
		}
		if(i==m-1 && j==n-1) {
			return 1;
		}
		int right = helper(i, j+1, m, n);
		int bottom =  helper(i+1, j, m, n);
		return right+bottom;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int m =4;
		int n =4;
		System.out.println(s.uniquePaths(m, n));

	}

}

//BrutForce

//public int uniquePaths(int m, int n) {
//	return helper(0, 0, m, n);
//}
//
//public int helper(int i, int j, int m, int n) {
//	if(i >= m || j >=n) {
//		return 0;
//	}
//	if(i==m-1 && j==n-1) {
//		return 1;
//	}
//	int right = helper(i, j+1, m, n);
//	int bottom =  helper(i+1, j, m, n);
//	return right+bottom;
//}
