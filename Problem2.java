// Problem2: (https://leetcode.com/problems/unique-paths/)

// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// start from m-2, n-2
//Ever cell will number of possible paths from i,j+1 th cell (dp[j+1]) + number of possible paths from i+1,j th cell (dp[j])
//at the end dp[0] will have all possible paths from 0,0.

class Solution {
    public int uniquePaths(int m, int n) {
        int []dp = new int[n];
        for(int j=0;j<n;j++) dp[j]=1;
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[j]=dp[j]+dp[j+1];
            }
        }
        return dp[0];
    }
    
}