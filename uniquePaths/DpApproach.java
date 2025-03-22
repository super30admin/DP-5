package uniquePaths;

//In this approach, we use Bottom-up dp where we take a 2d dp array to store the number of unique paths at each cell
//To implement this, we start from the bottom right corner where we give the value 1 and as we come up, at each index, we add the value of the right cell and bottom cell values
//Finally, we return the first element in dp array as the number of unique paths from the starting index
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)

class DpApproach {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            // fill the bottom row
            dp[i][n-1] = 1;
        }

        for(int j = 0; j < n; j++) {
            // fill the bottom row
            dp[m-1][j] = 1;
        }

        for(int i = m-2; i >= 0; i--) {
            for(int j = n-2; j >= 0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }
}