//DP approach
//Time Complexity : O(m*n)
//Space Complexity : O(n)
class Solution {
    public int uniquePaths(int m, int n) {
         if(m==0){
            return 0;
        }
        //use a dp array to store sunproblem soulutions
        int[] dp = new int[n+1];
        //in case of just one row amd n cols, there will be just one way o reach the destination
        for(int i=1;i<n+1;i++){
            dp[i] = 1;
        }
        //fill the dp array
        for(int j=1;j<m;j++){
            for(int i=1;i<n+1;i++){
                //the res for the current cell lies in the cell directly above the curr cell and prev col same row
                dp[i] = dp[i-1] + dp[i];
            }
        }
        return dp[n];
    }
}
//Brute force : Time Limit exceed
//Time Complexity : O(m*n)
//Space Complexity : O(1)
class Solution {
    public int uniquePaths(int m, int n) {
        if(m==0){
            return 0;
        }
        //start from 0th row and 0th col
        return helper(m,n,0,0);
    }
    private int helper(int m, int n, int row, int col){
        //if row and col is out of bounds destination is not reached
        if(row==m || col==n){
            return 0;
        }
        //if destination is reached, then this is a possible path
        if(row == m-1 && col == n-1){
            return 1;
        }
        //check the down and right direction next
        return helper(m,n,row+1,col) + helper(m,n,row,col+1);    
    }
}