// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: Tabulation DP
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]= new int[m][n];

        //base
        dp[0][0]=1;

        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(i>0){
                    dp[i][j]+= dp[i-1][j];
                }
                if(j>0){
                    dp[i][j]+= dp[i][j-1];   
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}    
