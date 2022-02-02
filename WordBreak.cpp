
//Time Complexity O(m*n)
// Space Complexity O(m*n))
//Problem successfully executed on leetcode
//No problems faced while coading this.

#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
#include<unordered_set>
using namespace std;

class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        
        vector<int> dp(s.size()+1,0);
        dp[0]=1;
        unordered_set<string> dict;
        for(auto & word: wordDict)
        {
            dict.insert(word);
        }
        
        for(int i=1;i<dp.size();i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j]==0) continue;
                
                int numberOfWordsToLook=i-j;
                string sub = s.substr(j,numberOfWordsToLook);
                {
                    if(dict.find(sub)!=dict.end())
                    {
                        dp[i]=1;
                    }
                }
            }
        }
        return dp[s.size()];
    }
};