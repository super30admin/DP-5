
// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We can optimized below solution to use single array

public int UniquePaths(int m, int n) {
        
    if(m == 0 && n== 0)
        return 0;
    
    int[] dp = new int[n];
    for(int i = 0; i < n; i++)
    {
        dp[i] = 1;
    }
    
    for(int i = m-2; i >= 0; i--)
    {
        for(int j = n-2; j >= 0; j--)
        {
            dp[j] = dp[j] + dp[j+1];
        }
    }
    
    return dp[0];
}

//bottom up approach
//TC: O(m*n)
//SC: O(m*n)
public int UniquePaths(int m, int n) {
        
    if(m == 0 && n== 0)
        return 0;
        
    //to reach end for single column is one path
    //to reach end for single row is one path
    
    //after filling bootom row and last column
    //we just traversed back up, summing bottom and right unique paths
    int[,] dp = new int[m+1, n+1];
    dp[m-1, n-1] = 1;
    for(int i = m-1; i >= 0; i--)
    {
        for(int j = n-1; j >= 0; j--)
        {
            if(i == m-1 && j == n-1)
                continue;
            dp[i,j] = dp[i+1, j] + dp[i, j+1];
        }
    }
    
    return dp[0,0];
}

public int UniquePaths(int m, int n) {
        
    if(m == 0 && n== 0)
        return 0;
    
    int[,] paths = new int[m,n];
    
    for(int i = 0; i < m; i++)
    {
        paths[i,n-1] = 1;
    }
    
    for(int i = 0; i < n; i++)
    {
        paths[m-1,i] = 1;
    }
    
    //after filling bootom row and last column
    //we just traversed back up, summing bottom and right unique paths
    for(int i = m-2; i >= 0; i--)
    {
        for(int j = n-2; j >= 0; j--)
        {
            paths[i,j] = paths[i+1,j] + paths[i,j+1];
        }
    }
    
    return paths[0,0];
}