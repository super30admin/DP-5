/*
Approach
No of ways down + no of ways right
Time Complexity : O(mxn)
Space Complexity:O(mxn)
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        for(int i= m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(i==m-1 && j==n-1) continue; // last row & col - starting point
                else if(i== m-1) { // last entire row as 1
                    dp[i][j] = 1;
                }
                else if(j == n-1){ // last entire column as 1
                    dp[i][j]= 1;
                }
                else{
                dp[i][j] = dp[i+1][j]+dp[i][j+1]; // no of ways to reach down + no of ways to reach right
                }
            }
        }
        return dp[0][0]; 
    }
}



// brute force
/*
Time complexity: 2^(mxn)
Space complexity : Stack space O(mxn)
*/
class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0,0,m,n);
    }
    
    private int helper(int i,int j, int m, int n) {
        //base
        if(i==m-1 && j==n-1) return 1; //starting point reached ie 1
        if(i>=m || j>=n) return 0;  //out of bounds
        //logic
        int right = helper(i,j+1,m,n);
        int down = helper(i+1,j,m,n);
        return right+down;
    }
}