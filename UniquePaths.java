// Approach : Recursively explore the paths with two choices down and right
// Time : 2^(m+n)
// Space : O(h) // m+n
class Solution {
    int count;
    public int uniquePaths(int m, int n) {
        helper(m,n,0,0); // send start position..
        return count;
    }
    public void helper(int m, int n, int i, int j){
        // base case - when you reach the destination
        if(i == m-1 && j == n-1){
            count++;
            return;
        }

        // out of bounds check
        if(i == m || j ==n){
            return;
        }

        // logic
        // Recursion - move right
        helper(m,n,i,j+1);
        // Recursion - move down
        helper(m,n,i+1,j);
    }
}

// Approach : Recursively explore the paths with two choices down and right
// Time : 2^(m+n)
// Space : O(h) // m+n
class Solution {
    public int uniquePaths(int m, int n) {
        return helper(m,n,0,0); // send start position..
    }
    public int helper(int m, int n, int i, int j){
        // base case - when you reach the destination
        if(i == m-1 && j == n-1){
            return 1; // valid paths count
        }

        // out of bounds check
        if(i == m || j ==n){
            return 0;
        }

        // logic
        // Recursion - move right
        int case0= helper(m,n,i,j+1);
        // Recursion - move down
        int case1 =helper(m,n,i+1,j);

        return case0 + case1;
    }
}

// Approach : DP with memoization - Top down approach. memoize the small problems results during the recursion
// Time : O(m*n)
// Space : O(m*n) + O(h) // stack space
class Solution {
    int[][] memoArray;
    public int uniquePaths(int m, int n) {
        this.memoArray = new int[m][n];
        return helper(m,n,0,0); // send start position..
    }
    public int helper(int m, int n, int i, int j){
        // base case - when you reach the destination
        if(i == m-1 && j == n-1){
            return 1; // valid paths count
        }

        // out of bounds check
        if(i == m || j ==n){
            return 0;
        }

        if(memoArray[i][j]!=0) return memoArray[i][j];

        // logic
        // Recursion - move right
        int case0= helper(m,n,i,j+1);
        // Recursion - move down
        int case1 =helper(m,n,i+1,j);

        memoArray[i][j] = case0 + case1;
        return case0 + case1;
    }
}

// Approach : DP with tabulation
// Time : O(m*n)
// Space : O(m*n)
class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        this.dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(i==0 || j ==0){
                    dp[i][j] = 1; // fill first row and first column with 1
                } else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    
}