// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class uniquePaths {
    public int uniquePaths(int m, int n) {
        // Method 1
        // if(m == 1 || n == 1){
        //     return 1;
        // }
        //  return uniquePaths(m, n-1) + uniquePaths(m-1, n);
        // method 2
//         int count[][] = new int[m][n];

//         for(int i=0 ;i<m; i++){

//                 count[i][0] = 1;

//         }

//         for(int j=0 ;j<n; j++){

//                 count[0][j] = 1;

//         }

//         for(int i=1; i<m; i++){
//             for(int j=1; j<n; j++){
//                 count[i][j] = count[i-1][j] + count[i][j-1];
//             }
//         }

//         return count[m-1][n-1];
        // method 3
        int dp[] = new int[n];
        dp[0] = 1;

        for(int i=0; i<m; i++){
            for(int j=1; j<n; j++){
                dp[j] += dp[j-1];
            }
        }

        return dp[n-1];
    }
}
