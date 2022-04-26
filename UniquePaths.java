//Time Complexity : O(m*n)
//Space Complexity : O(1)
public class UniquePaths {	
	/**Approach: DP**/
	public int uniquePaths(int m, int n) {        
        int[][] dp= new int[m+1][n+1];
        dp[m-1][n-1]=1; //there can be only 1 path while starting        
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(dp[i][j] ==0 ) {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }	
	
	// Driver code to test above
	public static void main (String[] args) {
		UniquePaths ob= new UniquePaths();
		int m=3;
		int n=7;
			
		System.out.print("Number of possible unique paths that the robot can take to reach the bottom-right corner: "+ob.uniquePaths(m,n));	
	}
}
