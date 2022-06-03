/* 
    Time Complexity                              :  O(N^2) due to the 2 loops in both the methods
    Space Complexity                             :  O(M*N) in the twoDArray approach and O(N) in the oneDArray approach
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/unique-paths/

class Solution {
public:
    int uniquePaths(int m, int n) {
        // return twoDArrayDP(m,n);
        return oneDArrayDP(m,n);
    }
    
    int twoDArrayDP(int m, int n) {
        vector<vector<int>> dp(m,vector<int>(n,0));
        for(int i=0;i<m;i++){
            dp[i][n-1] = 1;
        }
        
        for(int j=0;j<n;j++) {
            dp[m-1][j] = 1;
        }
        
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        
        return dp[0][0];
    }
    
    
    int oneDArrayDP(int m, int n) {
        vector<int> dp(n,1);
        for(int i=m-2;i>=0;i--) {
            for(int j=n-2;j>=0;j--) {
                dp[j] = dp[j] + dp[j+1];
            }
        }
        
        return dp[0];
    }
};