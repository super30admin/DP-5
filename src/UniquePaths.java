//DP Tabulation: Fill in the table with values added from right and bottom
//TC - O(m*n)
//SC - O(m*n)
class UniquePaths {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0;i<n;i++) {
            dp[m-1][i] = 1;
        }

        for(int i=0;i<m;i++) {
            dp[i][n-1] = 1;
        }
        for(int i = m-2;i>=0;i--) {
            for(int j=n-2;j>=0;j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}

// Same Approach of DP Tabluation
// TC - O(m*n)
// SC - O(n)
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[] = new int[n];
        for(int i=0;i<n;i++) {
            dp[i] = 1;
        }

        // for(int i=0;i<m;i++) {
        //     dp[i][n-1] = 1;
        // }
        
        for(int i = m-2;i>=0;i--) {
            for(int j=n-2;j>=0;j--) {
                dp[j] = dp[j+1] + dp[j];
            }
        }
        return dp[0];
    }
}

// DP Memoization
// TC - O(m*n)
// SC - O(m*n)
class Solution {
    int [][] memo;
    public int uniquePaths(int m, int n) {
        this.memo = new int[m][n];
        return helper(0,0,m,n);
    }
    private int helper(int i, int j, int m,int n) {
        // if(i==m || j==n) return 0;
        if(i==m-1 || j==n-1) return 1;
        if(memo[i][j]!=0) return memo[i][j];
        int caseR = helper(i,j+1,m,n);
        int caseD = helper(i+1,j,m,n);
        memo[i][j] = caseR + caseD;
        return memo[i][j];
    }
}