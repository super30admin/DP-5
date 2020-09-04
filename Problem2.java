// There are three approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach 1: Brute force
// 1. Recursive find right and down paths till you reach destination.
// 2. If indices go out of bound return 0 as path is not found.
// Time Complexity : O(2^(n*m))
//      n: number of rows
//      m: number of cols
// Space Complexity : O(max(n, m))
//      n: number of rows
//      m: number of cols
class Problem2S1 {
    
    // global matrix size
    int m;
    int n;

    /** find total number of unique paths */
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        return dfsHelper(0, 0); 
    }
    
    /** DFS traversal */
    private int dfsHelper(int i, int j){
        
        //base case
        // 1. reach destination
        if(i== n-1 && j ==m-1)
            return 1;
        // 2. out of bound
        else if(i >= n || j >= m)
            return 0;
        
        // get right path
        int right = dfsHelper(i, j+1);
        // get down path
        int down = dfsHelper(i+1, j);
        // return total path
        return right+down;
    }
}
// Your code here along with comments explaining your approach
// Approach 2: Dp
// 1. Initialize dp destination 's row and col as 1.
// 2. Iterate in reverse.
// 3. For every cell, number of paths is sum of right neighbor and left neighbor 's path.
// Time Complexity : O(n*m)
//      n: number of rows
//      m: number of cols
// Space Complexity : O((n)*(m))
//      n: number of rows
//      m: number of cols
class Problem2S2 {

    /** find total paths */
    public int uniquePaths(int m, int n) {
        
        // initialize dp
        int[][] dp = new int[m][n];

        // initialize row
        for(int i=0;i<m;i++)
            dp[i][n-1] = 1;
        
        // initialize col
        for(int j =0;j<n;j++)
            dp[m-1][j] = 1;
        
        // start from diagonal element above destination
        for(int i=m-2; i >= 0; i--){

            for(int j=n-2; j >= 0; j--){

                // add left and right path
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        // return result
        return dp[0][0];
    }
}
// Your code here along with comments explaining your approach
// Approach 3: Dp with extra one row and col
// 1. Initialize dp destination 's either right or down neighbor as 1.
// 2. Iterate from reverse
// 3. For every cell, number of paths is sum of right neighbor and left neighbor 's path.
// Time Complexity : O(n*m)
//      n: number of rows
//      m: number of cols
// Space Complexity : O((n+1)*(m+1))
//      n: number of rows
//      m: number of cols
class Problem2S3 {

    /** find total paths */
    public int uniquePaths(int m, int n) {
        
        // initilaize dp
        int[][] dp = new int[n+1][m+1];
        dp[n][m-1] = 1; // make either of the destination's neighbor as 1 (right/down)
        
        // iterate from the destination
        for(int i=n-1; i>=0; i--){
            
            for(int j=m-1; j>= 0; j--){

                // given cell path -> right path + down path
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        // return result
        return dp[0][0];
    }
}