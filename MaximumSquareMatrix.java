
// Time O(M*N)
// SPace O(M*N)
public class MaximumSquareMatrix {

    public int maximalSquare(char[][] matrix) {
           int r = matrix.length;
           int c = matrix[0].length;
	        int[][] dp = new int[r + 1][c + 1];
	        int maxsqlen = 0;
      
	        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}
