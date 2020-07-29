// 62.
class Solution {
    public int uniquePaths(int m, int n) {
        //return recursiveHelper(0, 0, m, n);
        return uniquePathFinder(m, n);
    }
    
    //time - O(2^(m*n)) - 2 choices at each cell and a total of m*n cells
    //space - O(m*n) - for the call stack
    private int recursiveHelper(int row, int col, int m, int n) {
        //base
        if(row == m - 1 && col == n - 1) //reached the bottom right cell
        {
            return 1;
        }
        if(row >= m || col >= n) //co ordinates out of bounds
        {
            return 0;
        }
        //logic
        //at any point, robot can travel to the next right cell (i, j + 1) or the below cell(i + 1, j)
        //total number of ways is sum of 2 options
        return recursiveHelper(row, col + 1, m, n) + recursiveHelper(row + 1, col, m, n);
    }
    
    //time - O(m * n)
    //space - O(m * n)
    private int uniquePathFinder(int m, int n) {
        int[][] result = new int[m][n];
        
        //base
        //to reach any cell in the 1st row from (0,0), there is only one way to continously go right till that cell
        for(int i = 0; i < n; i++)
        {
            result[0][i] = 1;
        }
        //to reach any cell in the 1st col from (0,0), there is only one way to continously go down till that cell
        for(int i = 0; i < m; i++)
        {
            result[i][0] = 1;
        }
        
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                //a cell (i,j) is reachable only from (i-1, j) - top and (i, j - 1) - left
                //so # of ways to (i, j) is the sum of 2 options
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        
        return result[m - 1][n - 1];
    }
}
