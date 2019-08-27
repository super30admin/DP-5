//
// Created by shazm on 8/27/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution {
// public:
//     int uniquePaths(int m, int n) {
//         return recurr(m,n,0,0);
//     }
// private:
//     int recurr(int m, int n, int i, int j){
//         if(i==m-1 && j==n-1){
//             return 1;
//         }
//         if(i<m-1 && j<n-1){
//             return recurr(m,n,i+1,j) + recurr(m,n,i,j+1);
//         }
//         if(i<m-1){
//             return recurr(m,n,i+1,j);
//         }
//         if(j<n-1){
//             return recurr(m,n,i,j+1);
//         }
//         return 0;
    // }
public:
    int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        if(m==1 || n==1) return 1;
        int dp[m][n];
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }
        for(int j=0; j<n; j++){
            dp[0][j] = 1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
};