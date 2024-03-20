package week9.day2;
//TC - O(m*n)
//SC - O(m*n)
//Bottom up DP - tabulation
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        
        for(int i=m-1;i>=0;i--){  
            for(int j=n-1;j>=0;j--){  
                if(i==m-1 && j==n-1){
                    dp[i][j]=1;   //initialize finish location to 1
                    continue;
                } 
                else
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
