//Time Complexity: O(mn)
//Space Complexity: O(mn)
//Accepted on leetcode
//The aim is to find the number of unique paths from start to end given that the romot can only move right and down
//We can break this by finding the number of paths to reach the first box and based on the answer calculated for that box we calculate the number of paths for the next box and so on...
//The Key formula to calculate this is marked in the code below.
//at the end the last box in the dp matrix on right bottom corner contains our answer which is the total number of unique paths to reach the desitination.
class Solution {
    public int uniquePaths(int m, int n) 
    {
        int[][] dp = new int[m][n];
        for(int i=0; i<dp.length; i++)
        {
           dp[i][0]=1;
        }
        for(int i=0; i< dp[0].length;i++)
        {
            dp[0][i]=1;
        }
        for(int i=1; i<dp.length; i++)
        {
            for(int j=1; j<dp[i].length; j++)
            {
                dp[i][j]=dp[i-1][j] + dp[i][j-1]; //KEY FORMULA.
            }
        }
        return dp[m-1][n-1];
    }
}