//bottom up
// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         dp[0][0] = 1;

//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(i==0&&j==0)
//                     continue;
//                 dp[i][j] = helper(dp, i-1,j) + helper(dp, i, j-1);
//             }
//         }
//         return dp[m-1][n-1];
//     }

//     int helper(int [][]dp, int m, int n){
//         if(m<0 || m>=dp.length || n<0 || n>dp[0].length)
//             return 0;
//         return dp[m][n];
//     }
// }

//top down
class Solution {
    public int uniquePaths(int m, int n) {
        int nums[][] = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                nums[i][j] = i==0||j==0?1:-1;
        nums[0][0] = 1;
        return helper(nums, m-1, n-1);
    }

    public int helper(int nums[][], int m, int n){
        if(nums[m][n]!=-1) //already computed, no need to do again
            return nums[m][n];

        nums[m][n] = helper(nums, m-1, n) + helper(nums, m, n-1);
        return nums[m][n];
    }
}