
//Time Complexity: O(n*m)
//Space Complexity: O(n*m)

//we use dynamic programming to solve this problem
//we create a 2D array dp where dp[i][j] represents the number of unique paths to reach cell (i,j)
//when we are at first row or first column, we can only come from one direction (either from the left or from above)
//we then iterate through the array and for each cell (i,j), we set dp[i][j] = dp[i-1][j] + dp[i][j-1]
//finally we return dp[n-1][m-1] which represents the number of unique paths to reach the bottom-right corner of the grid
//We can also optimize the space complexity to O(m) by using a 1D array instead of a 2D array


class Solution {
    public int uniquePaths(int n, int m) {
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0)
                    dp[i][j]=1;
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }
}