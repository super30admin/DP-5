//Approach: make first row and first coln (or last)1
//add an element from left and up and add them to get this element.

//TC:O(m*n)
//SC:O(m*n)
class Solution {
    public int uniquePaths(int cols, int rows) {
        int[][] dp = new int[rows][cols];
        
        for(int row=0;row<rows;row++)
            dp[row][0] = 1;
        
        for(int col=0;col<cols;col++)
            dp[0][col] = 1;
        
        for(int i=1;i<rows;i++)
            for(int j=1;j<cols;j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        
        return dp[rows-1][cols-1];
        //return the last element
        
    }
}