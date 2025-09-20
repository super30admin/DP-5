// This solution uses a dp array to store number of steps needed to reach a particular box
// If it is first row or first column we consider there is only way to reach there
// Otherwise we take sum from top element and left element. 
// In this case top element is the present element in the dp array.
class Solution {
    
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i==0 || j==0) dp[j] = 1;
                else dp[j] = dp[j]+dp[j-1];
            }
        }

        return dp[n-1];
    }
}
