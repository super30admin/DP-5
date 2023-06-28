
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


// Approach : dp with memoization
// Time Complexity : O(n^3) ( n = s.size())
// Space Complexity : O(n + wordDict.size()*word[0].size())     (n for resurrsive stack)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    int dp[301];
    unordered_set<string>set;
    bool recurse(int idx,string &s)
    {
        if(idx==s.size()) return true;
        if(dp[idx]!=-1) return dp[idx];
        for(int i = idx;i<s.size();i++)
        {
            if(set.count(s.substr(idx,i-idx+1)) && recurse(i+1,s)) return dp[idx]=true;
        }
        return dp[idx]=false;
        
    }
    bool wordBreak(string s, vector<string>& wordDict) {
        int n = s.size();
        memset(dp,-1,sizeof(dp));
        for(auto& p: wordDict){
            set.insert(p);
        }
        return recurse(0,s);
    }
};


// Approach : dp bottom up
// Time Complexity : O(n^3 *k) ( n = s.size()) (k is average length of string in wordDict)
// Space Complexity : O(n + wordDict.size()*word[0].size()) (dp array + hashset)
// Did this code successfully run on Leetcode : yes

class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string>set(wordDict.begin(),wordDict.end());
        int n = s.size();
        vector<bool>dp(n+1,false);
        dp[0] = true;
        for(int i = 1;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j] && set.count(s.substr(j,i-j))>0){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
};