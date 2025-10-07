#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use a boolean array dp to track whether each prefix of the string can be partitioned.
For each position in the string, we check earlier positions to see if the word between them is in the dictionary and the earlier position is reachable.
If both conditions are true, we mark the current position as reachable and continue
*/
class Solution{
public:
    bool wordBreak(string s, vector<string>& wordDict){
        unordered_set<string> set(wordDict.begin(), wordDict.end());
        int n = s.length();

        vector<bool> dp(n+1, false);
        dp[0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.find(s.substr(j, i - j)) != set.end()){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
};
