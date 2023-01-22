import java.util.Arrays;
//https://leetcode.com/problems/unique-paths/description/
public class UniquePaths {
    //TC - O(m*n) //SC O(n)
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = m-2; i >=0 ; i--) {
            for (int j = n-2; j >=0 ; j--) {
                dp[j] = dp[j]+dp[j+1];
            }

        }
        return dp[0];
    }


//TC - O(m*n) //SC O(m*n)
    /*
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] dp = new int [m+1][n+1];

        for (int i = m-1; i >=0 ; i--) {
            for (int j = n-1; j >=0 ; j--) {
                dp[i][j] = dp[i][j+1]+dp[i+1][j];
            }

        }
return dp[0][0];


    }*/
//TC exponential
    /*
    public int uniquePaths(int m, int n) {
        if(m==0||n==0) return 0;
        return recurse(m,n,0,0);
    }
    private int recurse(int m, int n, int r, int c ){
        if(r==m||c==n) return 0;
        if(r==m-1 && c==n-1) return 1;
        int right = recurse(m,n,r,c+1);
        int bottom = recurse(m,n,r+1,c);
        return right +bottom;
    }*/
}
