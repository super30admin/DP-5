// Time Complexity : O(MN)
// Space Complexity :O (N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
   class Solution {
    public int uniquePaths(int m, int n) {
        
//     int dp[][]=new int[m+1][n+1];
//     dp[m-1][n-1]=1;
        
//     for(int i=m-1;i>=0;i--){
//         for(int j=n-1;j>=0;j--)
//         {
//             dp[i][j]+=dp[i+1][j]+dp[i][j+1];
//         }
//     }
        
//      return dp[0][0];


// If we have a matrix of 1 * n horizontal , then only we have 1 path. 
// Similarly ,for n*1 matrix it is vertical , still only 1 path.
// For 2*2 , it is either R-D or D-R , which makes it 2. It is the sum of right and down ways.
// The same approach is implemented with 1D array space. As last row and last column are completely 1's in 2D array, 
// we can have last element as 1 . The present value is sum of old right ( now dp[j+1] ) and old bottom which is dp[j] itself. 

    if(m==0) return 0;

    int dp[]=new int[n];

    Arrays.fill(dp,1);
        
    for(int i=m-2;i>=0;i--){
        for(int j=n-2;j>=0;j--)
        {
            dp[j]=dp[j+1]+dp[j];
        }
    }
        
     return dp[0];
    
    }  
}