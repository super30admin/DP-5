// Time Complexity : O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

// We will be recursively memoizing the count of already found paths. We will start from the top and recursing back to the top 


class Solution {
    private int [][] dp;
    public int uniquePaths(int m, int n) {
        dp=new int [m+1][n+1];
        return dfs(0,0,m,n);
    }
    private int dfs(int i,int j, int m,int n)
    {
        //base
        if(i==m || j==n) return 0;
        if(i==m-1 && j==n-1) return 1;

        //logic
        if(dp[i+1][j]==0)   //if the cell below has 0
        {
            dp[i+1][j]=dfs(i+1,j,m,n);
        }
        int case1=dp[i+1][j];
        if(dp[i][j+1]==0)   //if the cell on the right has 0
        {
            dp[i][j+1]=dfs(i,j+1,m,n);
        }
        int case2=dp[i][j+1];

        return case1+case2;
    }
}

// Bottom up DP: The rightmost column and the bottom most row of the matrix will be 1, 
// since there will be only one way to reach the destination from there. We have repeated 
// sub problems as the number of paths from every cell will be the sum of the number of 
// paths found from the cell below and from the cell on the right. We will start calculating from 
// bottom right, then the result will be stored in the first cell of the matrix. TC: O(mn)

class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp=new int[m+1][n+1];
        dp[m-1][n-1]=1;

        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(i==m-1 && j==n-1) continue;
                dp[i][j]=dp[i+1][j]+ dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}// 1D DP

class Solution {
    public int uniquePaths(int m, int n) {
        int []dp=new int[n+1];
        dp[n-1]=1;

        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-2;j>=0;j--)
            {
                if(i==m-1 && j==n-1) continue;
                dp[j]=dp[j]+ dp[j+1];
            }
        }
        return dp[0];
    }
}





// DFS: From every cell we can move either down or right. So starting from (0,0) the sum of number of paths received from going down and the number of paths received from going right, will give us the result
// TC: O(2^m+n) SC: O(m*n)

class Solution {
    public int uniquePaths(int m, int n) 
    {
        return dfs(0,0,m,n);
    }
    private int dfs(int i, int j, int m, int n)
    {
        //base
        if(i==m || j==n) return 0;
        if(i==m-1 && j==n-1) return 1;

        //logic
        //moving down
        int case1= dfs(i+1,j,m,n);
        //moving right
        int case2=dfs(i,j+1,m,n);

        return case1+case2;

    }
}