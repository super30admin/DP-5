// TC: O(mn) traversing the matrix for m rows and n columns
// SC: O(mn) for storing values in the matrix

public class uniquePaths {

	public int UniquePaths(int m, int n) {
		// if any of the values is 0, return 0
		if(m == 0 || n == 0)
			return 0;
		// create a matrix where we can store the values of the path
		int[][] cache = new int[m][n];
		// traverse from the last row and column
		for(int i = m-1;i>=0;i--) {
			for(int j=n-1;j>=0;j--) {
				// if the row is last or if the column is last, update the matrix value to 1 and continue because we cannot 
				// move ahead in the matrix with row or column
				if( i == m-1 || j == n-1)
				{
					cache[i][j] = 1;
					continue; // continue so that we dont go out of array index
				}
				// update our matrix with the sum of right value and down value because this will provide us the paths possible for the starting point
				// we know we can only travel right and down, summing those 2 values will provide us the path to the starting point
				cache[i][j] = cache[i+1][j] + cache[i][j+1];
			}
		}
		// since we traversed from last and kept storing the values to the initial rows and columns in matrix, we return the
		// first row and column value which 0th row and column value
		return cache[0][0];
	}
	
	public static void main(String[] args) {
		
		uniquePaths up = new uniquePaths();
		System.out.println(up.UniquePaths(3, 7));
	}
}
