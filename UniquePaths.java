//Leetcode - 62
//TimeComplexity -O(M*N)
//SpaceComplexity -O(M*N)
public class UniquePaths {
    //Memoization(Top-down resursion)
    int [][] memo;
    public int uniquePaths(int m, int n) {
        this.memo = new int[m][n];
        return helper(0, 0, m, n);
    }
    private int helper(int i, int j, int m, int n) {
        //base
        if(i == m-1 && j == n-1) return 1;
        //logic
        int case1 = 0;
        if(j+1 < n) {
            if(memo[i][j+1] == 0) {
                memo[i][j+1] = helper(i, j+1, m, n);
            }
            case1 = memo[i][j+1];
        }
        int case2 = 0;
        if(i+1 < m) {
            if(memo[i+1][j] == 0) {
                memo[i+1][j] = helper(i+1, j, m, n);
            }
            case2 = memo[i+1][j];
        }
        return case1+case2;
    }

    //bottom-up
    /*
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m+1][n+1];
        dp[m-1][n-1]=1;
        for(int i = m-1; i >=0; i--) {
            for(int j = n-1; j>=0; j--) {
                if(i == m-1 && j == n-1) continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
     */
}
