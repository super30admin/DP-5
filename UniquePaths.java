//In this approach, we use Bottom-up dp where we take a 2d dp array to store the number of unique paths at each cell
//To implement this, we start from the bottom right corner where we give the value 1 and as we come up, at each index, we add the value of the right cell and bottom cell values
//Finally, we return the first element in dp array as the number of unique paths from the starting index
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j>=0; j--){
                if(i == m-1 && j == n-1){
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
                
            }
        }
        return dp[0][0];
    }

}