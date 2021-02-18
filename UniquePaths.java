/*
method 1: using recursion, exponential time

method 2: using 2d dp array.
Fill the dp array from bottom to top
time :O(mn)
space: O(mn)

methid 3: use 1d dp array
time :O(mn)
space:O(n)
*/
class Solution {
   
    int m;
    int n;
    public int uniquePaths(int m, int n) {
        
        this.m = m;
        this.n = n;
        
        // //method1
        // return helper(0,0);
        
        //method 2
        //using extra space just ot avoid the word of assigning last row and last col
//         int[][]dp = new int[m+1][n+1];
//         dp[m-1][n-1] = 1; //marking the endpoint as 1
        
//         for(int i = m-1; i >= 0;i--){ 
//             for(int j = n-1;j>= 0; j--){
//                 if(i == m-1 && j == n-1)continue; 
                
//                 dp[i][j] = dp[i][j+1]+dp[i+1][j]; //add what is on right and bottom
//             }
//         }
        
//         return dp[0][0];
        
        //method 3:
        int[]dp = new int[n];
        
        Arrays.fill(dp,1);
        //since we already filled the last row with 1, we start from previous row i.e m-2
        for(int i = m-2; i >= 0;i--){ 
            int right = 0;
            for(int j = n-1; j >= 0 ;j--){
                dp[j] = dp[j] + right;
                right = dp[j];
            }
        }
        
        return dp[0];
    }
    
    // private int helper(int row, int col){
    //     if(row == m-1  && col == n-1){
    //         return 1;
    //     }
    //     if(row > m  || col > n){
    //         return 0;
    //     }        
    //     return helper(row,col+1) + helper(row+1,col);
    // }
}