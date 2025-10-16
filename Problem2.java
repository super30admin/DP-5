// Time Complexity : O(m*n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//We use tabluation approach to solve the repeated subproblems
//As the robot can either move down or right we fill  the last row and last column as 1 as there is only one way out and recursively calculate the number of ways robot can move down or right
//the result will be at the top most cell at position (0,0)
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[] = new int[n];
        //fill the last row and last column with 1 as there is only one way
        Arrays.fill(dp, 1);
        for(int i = m-2; i >= 0; i--) {
            for(int j = n-2; j >= 0; j--) {
                dp[j] = dp[j+1] + dp[j];
            }
        }
        return dp[0]; 
    }
}
