package dp5;

//Idea : To calculate number of all possible unique path made by bottom right corner block,
// so we start from the bottom right corner and add the number of possible paths to the right and bottom of current cell.
// Do this till we reach 0,0 block.

//TC: O(m*n)
//SC: O(m*n)
public class UniquePaths {

public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m+1][n+1];
        dp[m - 1][n - 1] = 1;
        
        for(int i = m - 1; i >=0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 && j == n -1) {
                    continue;
                }
                dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
            }
        }
        return dp[0][0];
    }

// BRUTE FORCE : Recursive solution
/*

public int uniquePaths(int m, int n) {
       return helper(0, 0, m, n);
    }
    
    public int helper(int i, int j, int m, int n) {
        //Base case
        if(i > m - 1 || j > n - 1) return 0;
        if(i == m - 1 && j == n - 1) return 1;
        
        int right = helper(i, j + 1, m, n);
        int bottom = helper(i + 1, j, m, n);
        
        return right + bottom;
    }	

*/
}
