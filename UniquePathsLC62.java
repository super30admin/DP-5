class Solution {
    
    
    //Approach 5, Bottom Up Approach
    //Time Complexity: O(m*n)
    //Space Complexity: O(n)
    
    public int uniquePaths(int m, int n) {
     
        int[] dp = new int[n+1];                        //creating a dp array to store the number of unique paths possible from that index
        
        Arrays.fill(dp, 1);                             //fill the array with 1
        dp[n] = 0;                                         //from end there's no way to go end, so put zero
        
        for(int i=m-2; i>=0; i--){                      //iterate row from end to start
            for(int j = n-1; j>=0; j--){                //iterating column from end to beginning
                dp[j] = dp[j+1] + dp[j];                //dp[j] = dp[j+1] + dp[j]
            }
        }
        return dp[0];                                   //return dp[0]
    }
    
    
    
    
    
    //Approach 4, Bottom Up Approach
    // Time Compelxity: O(m*n)
    //Space Complexity : O(m*n)
    
//     public int uniquePaths(int m, int n) {
     
//         int[][] dp = new int[m+1][n+1];
//         dp[m-1][n-1] = 1;
        
//         for(int i = m-1; i>=0; i--){
//             for(int j = n-1; j>=0; j--){
                
//                 if(i == m-1 && j == n-1) continue;
                
//                 dp[i][j] = dp[i+1][j] + dp[i][j+1];
//             }
//         }
//         return dp[0][0];
//     }
    
    
    
    
    
    //Approach 3 Bottom Up Approach, here I have started from the start position, we can implement the from the end as well
    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n), we can optimize the space by O(n) because we don't need an entire 2D Array to store results, we just need one previous array for calculations
    
//     public int uniquePaths(int m, int n) {
        
//         int[][] dp = new int[m][n];
        
//         for(int i=0; i<m; i++){
//             dp[i][0] = 1;
//         }
        
//         for(int i=0; i<n;i++){
//             dp[0][i] = 1;
//         }
        
//         for(int i=1; i<m; i++){
//             for(int j=1; j<n; j++){
//                 dp[i][j] = dp[i-1][j] + dp[i][j-1];
//             }
//         }
//         return dp[m-1][n-1];   
//     }
    
    
    
    
    
    
    //Approach 2, Top Down Approach
    //Time Complexity: O(m*n)
    //Space Complexity: O(m*n)

//     int[][] dp;
    
//     public int uniquePaths(int m, int n) {
        
//         dp = new int[m][n];
//         return uniquePaths(0, 0, m, n);
//     }
    
//     private int uniquePaths(int i, int j, int m , int n){
        
//         if(i == m-1 && j == n-1) return 1;
        
//         if(i==m || j==n) return 0;
        
//         if(dp[i][j] == 0){
//             dp[i][j] = uniquePaths(i+1, j, m, n) + uniquePaths(i, j+1, m, n);
//         }
        
//         return dp[i][j];
//     }
    
    
    
    
    
    
    //Approach 1, Recursion Approach, Time Limit Exceed Error
    //Time Complexity: O(2^(m*n))
    //Space Complexity: O(max(m, n))
    
//     public int uniquePaths(int m, int n) {
     
//         return helper(0,0, m, n);
        
//     }
    
//     private int helper(int i, int j, int m, int n){
        
//         //base
//         if(i==m || j == n) return 0;
        
//         if(i == m-1 && j == n-1) return 1;
        
        
//         //logic
//         int right = helper(i+1, j, m, n);
//         int bottom = helper(i, j+1, m, n);
        
//         return right + bottom;
//     }    
}
