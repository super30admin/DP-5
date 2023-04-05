// Time Complexity : O(2^mn)
// Space Complexity : O(2^mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* recursively call every cell. helper function to call right and down direction paths.
 */     
class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0,0, m,n);
    }

    private int helper(int i, int j , int m , int n)
    {
        //base
        if(i == m || j == n)
            return 0;
        if(i == m - 1 && j == n - 1)
            return 1;
        
        //logic
        int right = helper(i, j+1,m,n);
        int down = helper(i+1, j, m,n);

        return right + down;
    }
}


//DP memoization

// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* using the DP memoization approach, we create a dp array to keep track of unique path values at a particular row and column,
 * if we don't have the value already solved we calculate by calling the recursive function else take it from the dp array.
 */     
class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        dp[m-1][n-1] = 1;
        return helper(0,0,m,n);
    }

    private int helper(int i, int j, int m, int n)
    {
        //base
        if(i == m || j == n)
            return 0;
        
        if(i == m - 1 && j == n - 1)
            return 1;

        //logic
        int right = 0;

        if(j + 1 < n )
        {
            if(dp[i][j+1] == 0)
            {
                dp[i][j+1] = helper(i, j+1,m,n);
            }
            right = dp[i][j+1];
        }

        int down = 0;
        if(i + 1 < m)
        {
            if(dp[i+1][j] == 0)
            {
                dp[i+1][j] = helper(i+1,j,m,n);
            }

            down = dp[i+1][j];
        }

        return right + down;
    }

}


//bottom up approach

// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* bottom up approach, we run for loop start =ing from end and iterate till the start of the matrix.
 * calculate dp[i][j] by taking the sum of right and down path.
 */     
class Solution {
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i = m -1 ; i >= 0 ; i--)
        {
            for(int j = n - 1 ; j >= 0 ; j--)
            {
                if(i == m - 1 && j == n - 1 )
                    continue;
                
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }

}




// 1 D DP 

// Time Complexity : O(mn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* 1d dp array, calculate the value for every column taking j and j+1 value
 */     
class Solution {
    
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = m -2 ; i >= 0 ; i--)
        {
            for(int j = n - 2 ; j >= 0 ; j--)
            {
                dp[j] = dp[j] + dp[j+1];
            }
        }
        return dp[0];
    }

}


