// Time Complexity :O(2^n)
// Space Complexity : O(2^n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//Recursive
//1. Traverse all the bottom and right paths till you reach the destination.
//2. When the destination is reached increase the count by 1.
//3. Return if the values go out of bound.
class Solution {
public:
    int uniquePaths(int m, int n) {
        //edge
        if(m==0 && n==0) return 1;
        
        //logic
        vector<vector<int>> dp(n,vector<int>(m,0));
        int row=0, col=0;
        while(col<m){
            dp[row][col] = 1;
            col++;
        }
        row=0; col=0;
        while(row<n){
            dp[row][col] = 1;
            row++;
        }
        for(row=1; row<n;row++){
            for(col=1;col<m;col++){
                dp[row][col] = dp[row-1][col]+dp[row][col-1];
            }
        }
        
        return dp[n-1][m-1];
    }
};
