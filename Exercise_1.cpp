/* 
    Time Complexity                              :  O(N^3) where N is the length of the string. Due to the 2 loops and substring operation.
    Space Complexity                             :  O(N) used to memoize the sub problem results in the dp array
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/word-break/

class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> st(begin(wordDict),end(wordDict));
        return dpp(s, st);
    }
    
    // dynamic programming
    bool dpp(string &s, unordered_set<string>& st) {
        int n = s.size();
        vector<bool> dp(n+1,false);
        dp[0] = true;
        for(int i=1;i<n+1;i++) {
            for(int j=0;j<i;j++) {
                string str = s.substr(j,i-j);
                if(dp[j] and st.find(str) != st.end()) {
                    dp[i] = true;
                }
            }
        }
        
        return dp[n];
            
    }
};