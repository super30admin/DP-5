//tabulation
class Solution {
    
    public int uniquePaths(int m, int n) {
       int dp[] = new int[n];
       
       
        for(int j=0;j<n;j++)
        {
            dp[j]=1;
        }

        for(int i=m-2;i>=0;i--)
        {
            for(int j=n-2;j>=0;j--)
            {
                    if(i==m-1 && j==n-1)
                    continue;
                     dp[j] = dp[j]+dp[j+1];
            }
        }
        return dp[0];
    }
    
}

//Time Complexity (TC): O(m * n)
//Space Complexity (SC): O(n)
//m corresponds to the number of rows.
//n corresponds to the number of columns.