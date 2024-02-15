// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Recursion - First break the words into substring and check if its present in the set
// if yes, return true or false -> Dp

// 740. Delete and Earn

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int helper(int i, string s, unordered_set<string>& wordDict, vector<int>& dp){
        if(i == s.length()) return 1;
        if(dp[i] != -1) return dp[i];
        string temp = "";
        for(int j=i;j<s.length();j++){
            temp += s[j];
            if(wordDict.find(temp) != wordDict.end()){
                if(helper(j+1,s,wordDict,dp)) return dp[i] = 1;
            }
        }
        return dp[i] = 0;
    }
    bool wordBreak(string s, vector<string>& wordDict) {
        vector<int> dp(s.length(),-1);
        unordered_set<string> st;
        for(auto a : wordDict){
            st.insert(a);
        }
        return helper(0,s,st,dp);
    }
};