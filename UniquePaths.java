import java.util.Arrays;

public class UniquePaths {

    //bottom up DP
    //Time complexity: O(m * n)
    //Space complexity: O(n)
    //Did it run on Leetcode: yes
     public int uniquePathsBottomUpDPSpaceOptimized(int m, int n) {
         if(m < 0 || n < 0){
             return 0;
         }
         int[] dp = new int[n];
         Arrays.fill(dp, 1);

         for(int i=1; i<m; i++){
             for(int j=0; j<n; j++){
                 if(j == 0){
                     dp[j] = 1;
                 }else{
                     int upPaths =  dp[j];
                     int leftPaths = dp[j-1];

                     dp[j] = upPaths + leftPaths;
                 }
             }
         }
         return dp[n-1];
     }




    //bottom up DP
    //Time complexity: O(m * n)
    //Space complexity: O(m * n)
    //Did it run on Leetcode: yes
     public int uniquePathsBottomUpDP(int m, int n) {
         if(m < 0 || n < 0){
             return 0;
         }
         int[][] dp = new int[m][n];
         Arrays.fill(dp[0], 1);


         for(int i=1; i<m; i++){
             for(int j=0; j<n; j++){
                 if(j == 0){
                     dp[i][j] = 1;
                 }else{
                     int upPaths =  dp[i-1][j];
                     int leftPaths = dp[i][j-1];

                     dp[i][j] = upPaths + leftPaths;
                 }
             }
         }
         return dp[m-1][n-1];
     }

    //Top Down DP
    //Time complexity: O(m * n)
    //Space complexity: O(m * n)
    //Did it run on Leetcode: yes
    public int uniquePaths(int m, int n) {
        if(m < 0 || n < 0){
            return 0;
        }
        int[][] dp = new int[m][n];
        return explorePaths(0, 0, m, n, dp);
    }

    private int explorePaths(int rowIdx, int colIdx, int numberOfRows, int numberOfColumns,  int[][] mem){
        if(rowIdx == numberOfRows-1 && colIdx == numberOfColumns-1){
            return 1;
        }
        int caseDown = 0;
        int caseRight = 0;
        //down
        if(rowIdx < numberOfRows - 1){
            if(rowIdx < numberOfRows -1  && mem[rowIdx + 1][colIdx] == 0){
                mem[rowIdx + 1][colIdx] = explorePaths(rowIdx + 1, colIdx, numberOfRows, numberOfColumns, mem);
            }
            caseDown = mem[rowIdx + 1][colIdx];
        }
        //right
        if(colIdx < numberOfColumns -1){
            if(mem[rowIdx][colIdx + 1] == 0){
                mem[rowIdx][colIdx + 1] = explorePaths(rowIdx, colIdx + 1, numberOfRows, numberOfColumns, mem);
            }
            caseRight = mem[rowIdx][colIdx + 1];
        }

        mem[rowIdx][colIdx] =  caseDown + caseRight;
        return mem[rowIdx][colIdx];
    }


    //Time complexity: O(2 ^ (m * n))
    //Space complexity: O(m + n )
    //Did it run on Leetcode: No, gave Time Limit Exceeded
     //Exhaustive Brute Force solution
     public int uniquePathsBruteForce(int m, int n) {
         if(m < 0 || n < 0){
             return 0;
         }
         return explorePaths(0, 0, m, n);
     }

     private int explorePaths(int rowIdx, int colIdx, int numberOfRows, int numberOfColumns){
         if(rowIdx == numberOfRows-1 && colIdx == numberOfColumns-1){
             return 1;
         }
         if(rowIdx >= numberOfRows || colIdx >= numberOfColumns){
             return 0;
         }
         int caseDown = explorePaths(rowIdx + 1, colIdx, numberOfRows, numberOfColumns);
         int caseRight = explorePaths(rowIdx, colIdx + 1, numberOfRows, numberOfColumns);
         return caseDown + caseRight;
    }


}
