// Time Complexity : O(n^4) optimal
// Space Complexity : No. of words in the set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Word Break

#include<iostream>
#include<vector>
#include<string>
#include<set>
using namespace std;

class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        
        if(s.empty())
            return false;
        
        set<string> s1;
        
        for(int i = 0; i < wordDict.size(); i++){
            s1.insert(wordDict[i]);
        }
        
        vector<bool> dp(s.size() + 1, false);
        
        dp[0] = true;
        
        for(int i = 1; i < dp.size(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && s1.find(s.substr(j, i - j)) != s1.end()){ // before i
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[dp.size() - 1];
    }
};