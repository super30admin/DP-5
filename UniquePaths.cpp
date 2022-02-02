
//Time Complexity O(m*n)
// Space Complexity O(m*n))
//Problem successfully executed on leetcode
//No problems faced while coading this.

#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;


class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int> > dp(m,vector<int>(n,1));
        for(int i=m-2;i>=0;i--)
        {
            for(int j=n-2;j>=0;j--)
            {
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
    
};