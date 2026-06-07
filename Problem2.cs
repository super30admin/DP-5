// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I create a dp matrix of size m*n and fill the first row and column with 1s. This represents the number of ways in which I can reach those elements from the start. Then I fill up the rest of the 
elements of the matrix by summing up the values of the element just above it and just left of it. Intuition - the number of unique ways in which an element can be reached is the summation of
number of unique ways in which the element above it and the element left to it can be reached. At the end, I return the value of dp matrix at position m-1, n-1. 
*/

public class Solution
{
    public int UniquePaths(int m, int n)
    {
        int[,] dp = new int[m, n];

        // Fill first row and column with 1s
        for (int j = 0; j < n; j++)
        {
            dp[0, j] = 1;
        }

        for (int i = 0; i < m; i++)
        {
            dp[i, 0] = 1;
        }

        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                dp[i, j] = dp[i - 1, j] + dp[i, j - 1];
            }
        }

        return dp[m - 1, n - 1];
    }
}