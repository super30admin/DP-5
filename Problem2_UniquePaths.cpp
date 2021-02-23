// Time Complexity :  in Brute Force method it is exponential
                    //  in DP matrix it is O(m*n)
                    //In DP array it is O(m*n)
// Space Complexity : in Brute Force method it is recursive stack size
            //         in DP matrix its o(m*n) m and n being rows and columns
            // in DP array it is O(n) where n is number of columns
// Did this code successfully run on Leetcode :yes
// Did this code successfully run on Local Computer :yes
// Any problem you faced while coding this : no


// TC: in Brute force its exponential
//     in DP matrix the time complexity is O(m*n)
// SC: in Brute force it is the Recursive Stack size
//     in DP matrix the SC will be O(m*n)

// Using Brute Force

// class Solution {
// public:
//     int uniquePaths(int m, int n) {
        
        
//         return helper(m,n,0,0);
        
        
//     }

// private:
//     int helper(int m, int n, int i, int j){
//         //base
//         if(i==m || j==n) return 0; //we are actually outside the matrix so it must be 0
//         if(i==m-1 && j== n-1) return 1; //we reached the finish point or exit
        
//         //logic
//         return helper(m,n,i+1,j) + helper(m,n,i,j+1); //first we will go down and then take right
//     }
// };


// Using DP matrix

// class Solution {
// public:
//     int uniquePaths(int m, int n) {
        
//         vector<vector<int>> dp(m+1,vector<int> (n+1 , 0));
        
//         dp[m-1][n-1]=1;
        
//         for(int i=m-1;i>=0;i--){
//             for(int j=n-1;j>=0;j--){
//                 if(i==m-1 && j==n-1) continue;
//                 dp[i][j]=dp[i+1][j]+dp[i][j+1];
//             }
//         }
        
//         return dp[0][0];
        
        
//     }

// };


// Using DP array

class Solution {
public:
    int uniquePaths(int m, int n) {
        
        vector<int> dp(n+1, 1);//first we will start with all 1's as done in 
        
        
        
        // dp[m-1][n-1]=1;
        
        for(int i=m-2;i>=0;i--){ //it is m-2 because we are starting with second last row of the given matrix
            int right=0;//as at start of each row we need 0 to be added to existing element
            for(int j=n-1;j>=0;j--){
                // if(i==m-1 && j==n-1) continue;
                dp[j]=dp[j]+right;
                right=dp[j];
            }
        }
        
        return dp[0];
        
        
    }

};