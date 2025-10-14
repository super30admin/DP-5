/*
* Approach1: Use DFS to either go right or bottom and recursively explore all the paths (TC: O(2^(m+n)))
 - at every cell, you can either go right or bottom
 - if you are either in the last row or last coloumn, you only have one path to explore
    - last row - right path to explore
    - last column - bottom path to explore
 - once you are out of bounds, we dont need to explore further
 - The above solution is exhaustive but can be improved using memoization as there are overlapping subproblems
 - Memoization approach: As there are two input variables, we will create a dp matrix to store the number of routes one can go from that cell to reduce processing time
 - TC: O(m*n) - iterate through m * n cells
 - SC: O(m*n) // dp array to store m *n elements
*/
class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        this.memo = new int[m][n];
        return helper(m, n, 0, 0);
    }

    private int helper(int m, int n, int i, int j){
        //base
        // either last row or column return 1 as only one route is possible
        if(i == m - 1 || j == n - 1)
            return 1;
        // return 0 is out of bounds
        if(i == m || j == n)
            return 0;

        // if current cell is already explored, return the value instead of doing further recursive calls
        if(memo[i][j] != 0)
            return memo[i][j];

        //logic
        int right = helper(m, n, i, j + 1);
        int down = helper(m, n, i + 1, j);
        int res = right + down;
        //store the result int the dp array
        memo[i][j] = res;
        return res;
    }
}


/*
* Approach2: Tabulation (Bottom Up)
- Create an m *n matrix and fill the last row and last column with 1's as there is only one direction to go from that cell
- Else fill the cell with adding the right cell val + bottom cell val
- TC: O(m*n) - iterate through m * n cell to fill the dp matrix
- sC: O(m * n) - extra space to store m * n size dp matrix
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // iterate from last cell
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                //if either last row or column, add 1
                if(i == m - 1 || j == n - 1)
                    dp[i][j] = 1;
                // else summation of adjacent right and adjacent bottom cell
                else
                    dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}