//Problem 111 : Unique Paths
//TC: O(mn)
//SC: O(mn)

/* Steps:
1) BruteForce: TC: O(2^MN) 
               SC: O(m+n), for recursive stack
               We have two choices on each step either go down or right

2) Optimized : TC:O(mn) | SC:O(mn)
               Using DP: 
               1) Fill last column and last row with 1, then start filling the path from second last row and column
               2) For filling find sum of below coulmn and right column          
*/

class Solution111 {
    public int uniquePaths(int m, int n) {
        
        //Fill last column and last row with 1, then start filling the path from second last row and column
        //For filling find sum of below coulmn and right column
        //TC:O(mn) | SC:O(mn)
        int[][] dp = new int[m][n];
        
        //Fill last column
        for(int i=0;i<m;i++){
            dp[i][n-1] = 1;
        }
        
        //Fill last row
        for(int j=0;j<n-1;j++){
            dp[m-1][j] = 1;
        }
        
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                //For filling find sum of below coulmn and right column
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        
        
        return dp[0][0];
    }
}



/*class Solution {
    public int uniquePaths(int m, int n) {
        
        //have two choices for each box;
        
        return helper(m,n,0,0);
    }
    
    private int helper(int m, int n, int i, int j){
        
        //base
        if(i==m-1 && j==n-1) return 1;
        
        if(i==m || j==n) return 0;
        
        int result = helper(m,n,i+1,j) + helper(m,n,i,j+1);
        
        return result;
    }*/
    