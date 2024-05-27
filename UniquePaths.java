
class Solution {
    //Bottom up approach
    //Time Complexit: O(N) N-> number of columns
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n+1];
        dp[n-1] =1;

        for(int i =m-1; i>=0; i--)
        {
            for(int j =n-2; j>=0; j--)
            {
                if(i ==  m-1 && j == n-1) continue;
                dp[j] = dp[j+1] + dp[j];
            }
        }
        return dp[0];
        
    }
    
}