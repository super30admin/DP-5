// Time Complexity : O(2^(m*n)) where m and n is the number of rows and colums respectively/
// Space Complexity :O(m*n) - stack space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Exploring all the paths recursively.


class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0,0,m,n);
    }
    public int helper(int i,int j,int m,int n){
        //base
         if(i==m-1 && j==n-1) return 1;
         if(i>=m || j>=n) return 0;
        //logic
        int left=helper(i,j+1,m,n);
        int bottom=helper(i+1,j,m,n);
        return left+bottom;
    }
}

// Time Complexity : O(m*n))
// Space Complexity : O(m*n) - array space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: (Dp approach) Approach is to add all the paths possible from bottom by taking the  left and bottom. 

class Solution {
    public int uniquePaths(int m, int n) {
       int[][] dp=new int[m+1][n+1];
        dp[m-1][n-1]=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) continue;
                dp[i][j]=dp[i][j+1]+dp[i+1][j];
            }
        }
        return dp[0][0];
}
}