//Recursive Approach

//TC : O(2 power M*N)
//SC : Constant O(1)

//Idea : recursively , approach the target in each possible way.

class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0,0,m,n);
    }
    
    private int helper(int i,int j, int m,int n){
        //base case
        if(i>m-1 || j>n-1 ) return 0;
        //reaching the target
        if(i== m-1 && j==n-1 ) return 1;
        
        int right  = helper(i,j+1,m,n);
        int bottom = helper(i+1,j,m,n);  
        
        return right+bottom;
        
    }
}

 
// DP Approach

//TC : O(m*n)
//SC : O(m+1 * n+1)

// idea: make the dp array using the logic of adding the right and bottom value. from the end.

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i= m-1; i>= 0 ; i--){
            for(int j=n-1; j>=0; j--){
                if(i==m-1 && j==n-1) continue;
                dp[i][j] = dp[i][j+1]+dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}
