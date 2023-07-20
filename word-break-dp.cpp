// Time Complexity : O(n^3)
// Space Complexity : O(nL)
// Did this code successfully run on Leetcode : NO (Time Limit Exceeded)

#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

//dp
class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> set;
        for(auto it: wordDict){
            set.insert(it);
        }
        vector<bool> dp(s.size() + 1);
        dp[0] =  true;
        for(int i = 1; i < dp.size(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.find(s.substr(j, i - j)) != set.end()){
                    dp[i] = true;
                }
            }
        }
        return dp[dp.size() - 1];
    }
};