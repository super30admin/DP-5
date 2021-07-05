//Time Complexity:O(MN)
//SPace Complexity:O(MN)
//Approach- Create a new dp array with m rows and n columns. Iterate through each row and column and add the top and left element and assign it as the value to the current element if both row and column are greater than 0. Else simply assign 1. The last element of the matrix will have the total number of unique ways.
//This code was executed successfully and got accepted in leetcode.  
class Solution {
    public int uniquePaths(int m, int n) {
      int[][] dp=new int[m][n];
      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              if(i>0&&j>0){
                  dp[i][j]=dp[i-1][j]+dp[i][j-1];
              }
              else{
                  dp[i][j]=1;
              }
          }
      }
        return dp[m-1][n-1];
    }
}