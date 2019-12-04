package demo;
//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//How many possible unique paths are there?

//	Time:  O(m*n) 
//	Space O(m*n)
//	LeetCode: wrong answer in edge cases
public class UniquePath {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		//edge case
		if(m==0||n==0) return 0;
		if(Math.abs(m-n) == 1) return 1;
		//iterating over m*n matrix, O(m*n)
		for(int i=1; i < m ; i++){
			for(int j =1 ; j < n ; j++){
//				Making first row and column as 1
				dp[0][j] = 1;
				dp[i][0] =1 ;
//			since robot goes in 2 directions onle
//			then for each cell, keep adding top row and left column
				dp[i][j] = (dp[i-1][j]) + dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
	}
}
