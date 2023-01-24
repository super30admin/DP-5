/*
Top down DP with memoization:

We have to find number of ways from each cell to reach the finish line

when we already have found number of ways on a cell, and if we arrive on that cell, we dont have to traverse as we already would know the number


*/

// 3 solutions presented with different space complexities
class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        dp[m-1][n-1] = 1; // one way at the last
       // helper(0,0,m,n);
       // return dp[0][0];
       return botupoptimized(m,n);
    }

    // Time = O(m *n) , space O(m*n)
    // Bottom Up dp
    private int bottomup(int m,int n){

        int bp[][] = new int[m+1][n+1];
        // the last row will always be one , as there is only 1 way from any of the last row cell to go on target , which is 1

        bp[m][n-1] =1; // setting the finish spot as one

        // we will start at the finish spot and keep up filling the bp table till the start , at the start, we will have the number of ways 
        // bottom up
        for(int r = m-1;r>=0;r--){
            for(int c=n-1;c>=0;c--){
                bp[r][c] = bp[r][c+1] + bp[r+1][c]; // down + right
            }
        }

        return bp[0][0];

    }
    // Time = O(m *n) , space O(n)
    // Bottom Up dp
    private int botupoptimized(int m, int n){

        int[] bp = new int[n];
        bp[n-1]= 1;

        for(int r = m-1;r>=0;r--){
            for(int c=n-1;c>=0;c--){
                if(c<n-1){
                    bp[c] = bp[c] + bp[c+1];
                }
            }
        }

        return bp[0];
    }
// Time = O(m *n) , space O(m*n)
// Recurse with Memoization. Top Down
    private int helper(int r, int c, int m , int n){

        //base case
        if(r == m-1 && c == n-1){
            return 1;
        }
        //logic

        int right =0,down=0;

        // check if we already have arrived 
        if(dp[r][c] == 0){ // we need to find it
        if(c+1 < n)
        right += helper(r,c+1,m,n);
        if(r+1 < m)
        down += helper(r+1,c,m,n);

        dp[r][c] = right + down;
        }

        return dp[r][c];

    }
}