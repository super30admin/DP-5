// Time Complexity - O(mn) where m is the number of rows and n is the number of columns of the grid
// Space Complexity - O(mn) where m is the number of rows and n is the number of columns of the grid
// This solution worked on LeetCode
// This problem has repeated subproblems of calculating the unique paths. Using Dynamic programing we would be memoizing the number of paths from bottom right corner and keep adding them to the next upper cell. At the end the start will have the final answer. The dp matrix of m+1 and n+1 size is taken so that the cells at the right edges will add the right with 0 and the bottom with the non zero value. Similarly the edge bottom cells will add the bottom 0 value and the right cell non zero value. 

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] =1;
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                if(i == m-1 && j == n-1)    continue; // So that the last finish cell with is initialized as 1 above does not add up to 0 because both the bottom and right cell will 0 since the dp size is m+1 and n+1
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
