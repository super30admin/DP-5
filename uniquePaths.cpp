#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use tabulation with a one-dimensional array to compute paths row by row.
Every cell in the first row or column has only one way to reach it, so we set those to one. For all other cells, we add paths from the left and current values to build up the result.
This gives the total unique paths in dp[n-1] after processing all rows from top to bottom.
*/
class Solution{
public:
    int uniquePaths(int m, int n){
        vector<int> dp(n, 0);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0) dp[j] = 1;
                else dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }
};
