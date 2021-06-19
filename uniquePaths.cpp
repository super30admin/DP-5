// Time Complexity :O(nm) 
// Space Complexity : O(n)   
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<int> dp(n+1,1);
        int temp;
        dp[n] = 0;
        for(int i = m-2;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                temp = dp[j];
                dp[j] = dp[j+1] + temp;
            }
        }
        return dp[0];
    }
};