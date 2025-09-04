//Time Complexity:O(n*m*l) n=string length, m=wordDict length,l=max length of word in wordDict
//Space Complexity:O(n)
#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    bool helper(string& str, vector<string>& d, int idx, vector<int>& dp) {
        if (idx == str.length()) return true;
        if (dp[idx] != -1) return dp[idx];
        for (string& s : d) {
            if (idx + s.length() <= str.length() && 
                s == str.substr(idx, s.length())) {
                if (helper(str, d, idx + s.length(), dp)) 
                    return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
    bool wordBreak(string s, vector<string>& wordDict) {
        vector<int> dp(s.length(), -1);
        return helper(s, wordDict, 0, dp);
    }
};
