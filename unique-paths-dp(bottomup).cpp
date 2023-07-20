// Time Complexity : O(m^2 x n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<int> dp(n,0);

        for(int j = 0; j < n; j++){
            dp[j] = 1;
        }

        for(int i = m-2; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                dp[j] = dp[j] + dp[j+1]; 
            }
        }
        return dp[0];
    }
};