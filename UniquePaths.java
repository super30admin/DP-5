import java.util.*;

public class UniquePaths {

    //TC: O(NM)
    //SC: O(NM)
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i=m-1;i>=0;i--) {
            for(int j=n-1;j>=0;j--) {
                if(i == m-1 && j == n-1) {
                    continue;
                }
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }

    //TC: O(NM)
    //SC: O(NM)
    public int uniquePathTypeTwo(int m, int n) {
        int[][] d = new int[m][n];
        for(int[] arr : d) {
          Arrays.fill(arr, 1);
        }
        for(int col = 1; col < m; ++col) {
          for(int row = 1; row < n; ++row) {
            d[col][row] = d[col - 1][row] + d[col][row - 1];
          }
        }
        return d[m - 1][n - 1];
      }

    private int helperBF(int m, int n, int i, int j) {

        if (i == m || j == n) {
            return 0;
        }

        if (i == m - 1 || j == n - 1) {
            return 1;
        }

        return helperBF(m, n, i, j + 1) + helperBF(m, n, i + 1, j);
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        int result = uniquePaths.uniquePathTypeTwo(3, 3);
        System.out.println("The unique path is: " + result);
    }
}
