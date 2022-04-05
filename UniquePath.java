// class Solution {
//     int[][] dp;
    
//     public int uniquePaths(int m, int n) {
      
//         dp = new int[m][n];
        
        
//         return uniquePaths(0,0, m, n);
//     }
    
//     private int uniquePaths(int i , int j , int m , int n)
//     {
        
        
//         if(i==m-1 && j == n-1)
//         {
//             return 1;
//         }
        
//         if(i==m || j== n)
//         {
//             return 0;
//         }
        
        
        
            
//         return uniquePaths(i+1, j, m , n) + uniquePaths(i,j+1, m , n);
//     }
// }



/*
Time Complexity: O(rows*cols)
Space Complexity: O(rows*cols)
Run on leetcode: yes
Any difficulties: no
Approach:
1. Dynamic programming solution, as we know the robot can move right and down on the given grid and every step counts to 1
2. Attached the media with the repo to make solution more understandable
 */
 class Solution {
    public static int uniquePaths(int rows, int cols){
        int [][] dp = new int[rows][cols];

        // initializing first row and first column by one, that is initial state of the DP
        // Initializing row
        for(int i = 0; i<rows; i++){
            dp[i][0] = 1;
        }
        // initialization col

        for(int j = 0; j<cols; j++){
            dp[0][j] = 1;
        }

        // now let's try to reach at the bottom corner of the matrix using down and right movement

        for(int i = 1; i<rows; i++){
            for(int j = 1; j<cols; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[rows-1][cols-1];
    }
 }
