//Time: O(N)
//Space: O(N)
class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> wrd_set(wordDict.begin(),wordDict.end());
        vector<bool> dp(s.size()+1, false);
       
        dp[0] = true;
        
        for(int i=1; i<=s.size(); i++){
            for(int j=0; j<i; j++){
                auto it = wrd_set.find(s.substr(j,i));
                if(dp[j] && it!=wrd_set.end()){
                    dp[i] = true;
                }
            }
        }
        return dp[s.size()];
    }
};