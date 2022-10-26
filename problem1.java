// https://leetcode.com/problems/unique-paths/

// Time Complexity : O(n^2)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

public class problem1 {
    	public int uniquePaths(int m, int n) {
		 int[][] paths = new int[m][n];
		 int rows = m, cols = n;
		 for(int row = rows-1; row >=0; row--) {
			  for(int col = cols-1; col >= 0; col--) {
					if(row == rows-1 || col == cols-1) paths[row][col] = 1; 
					else
						 paths[row][col] = paths[row][col+1] + paths[row+1][col];
			  }
		 }
		 return paths[0][0];   
	}
}
