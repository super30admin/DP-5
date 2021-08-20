// Time Complexity : o(mn)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    
    //using recursion
	//TC: O(2^mn)
	//SC: recursive stack space O(mn)
    public int uniquePaths(int m, int n) {
        
        if(m==0||n==0)
            return 0;
        
        return helper(0,0,m,n);
    }
    
    private int helper(int sr,int sc,int er,int ec)
    {
        if(sr>er || sc>ec)
            return 0;
        if(sr==er-1 && sc==ec-1)
            return 1;
        
        return helper(sr+1,sc,er,ec)+helper(sr,sc+1,er,ec);
    }
    
    
    //using dp 2 dimensional array
  //TC: O(mn)
  //SC: O(mn) dp matrix
     public int uniquePaths(int m, int n)
     {
          if(m==0||n==0)
            return 0;
         
          int[][] dp=new int[m+1][n+1];
         
         dp[m-1][n-1]=1;
         
         for(int i=m-1;i>=0;i--)
         {
             for(int j=n-1;j>=0;j--)
             {
                 if(i==m-1 && j==n-1)
                     continue;
                 dp[i][j]=dp[i+1][j]+dp[i][j+1];
             }
         }
         return dp[0][0];
     }
     
    //using 1d array dp
   //TC: O(mn)
   //SC: O(n) dp matrix
      public int uniquePaths(int m, int n)
     {
          if(m==0||n==0)
            return 0;
         
          int[] dp=new int[n];
         
         Arrays.fill(dp,1);
         
         for(int i=m-2;i>=0;i--)
         {
             for(int j=n-2;j>=0;j--)
             {
                 
                 dp[j]=dp[j]+dp[j+1];
             }
         }
         return dp[0];
     }
    
}