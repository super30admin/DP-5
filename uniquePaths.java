// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int sum=0;
                if(i==0 && j==0){
                    dp[i][j]=1;
                }else{
                    if(j-1>=0)
                        sum+=dp[i][j-1];
                    if(i-1>=0)
                        sum+=dp[i-1][j];
                    
                    dp[i][j]=sum;
                }
                    
                
                
            }
        }
        return dp[m-1][n-1];
    }
}