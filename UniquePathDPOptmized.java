//Time Complexity - O(m*n)
//Space Complexity O(n)

class Solution {
    public int uniquePaths(int m, int n) {
      //edge case
      if(m == 0 && n == 0) {
        return 0;
      }
      //dp matrix
      int[] dp = new int[n];
      //bottom up dp therefore start from finish line 
      Arrays.fill(dp,1);
      
      for(int i=m-2;i>=0;i--) {
        //set initially right colum to zero
        int rightColumn = 0;
        for(int j = n-1;j>=0;j--) {
            dp[j] = dp[j] + rightColumn; 
          //dp[j] - provides value of bottom column
          //rightColumn - provides value of right column
            rightColumn = dp[j]; //update the right value
        }
      }
      return dp[0];
  }
}