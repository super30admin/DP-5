//Optimal Solution
//Bottom up approach
//Time Complexity: O(m*n)

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        //since is a bottom up approach; set[m-1][n-1]th element 1
        dp[m-1][n-1] = 1;
        //for each row and column bottome up approach
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>= 0; j--){
                //edge case
                if(i==m-1 && j==n-1)
                    continue;
                    //else add right and bottom element to know the path
                    //and so that we need not calculate the value again each time
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        //return value of the first element of the graph
        return dp[0][0];
    }
}

/********************************************************** */

//Brute Force
class Solution {
    public int uniquePaths(int m, int n) {
        //m: row; n:column
        return helper(0,0,m,n);
    }
    
    private int helper(int i, int j, int m, int n){
        //base case
        if(i == m-1 && j == n-1){
            //for last element -> 1
            return 1;
        }
        //edge case, if exceeds the row and column value
        if(i >= m || j>= n){
            return 0;
        }
        //logic
        //add 1 to column to reach next right element
        int right = helper(i, j+1, m, n);
        //add 1 to row to reach next bottom element
        int bottom = helper(i+1, j, m, n);
        return right+bottom;
    }
}