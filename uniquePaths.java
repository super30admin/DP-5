class Solution {
    public int uniquePaths(int m, int n) {
        
        int[] dp=new int[n];
        dp[0]=1;
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(j!=0)
                    dp[j]=dp[j-1]+dp[j];
        
        
        return dp[n-1];
        
    }
}

// Time Complexity : O(M*N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
