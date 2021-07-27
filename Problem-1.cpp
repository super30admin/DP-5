//word break, O(n^4 solution)
//taught in class
class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        vector<bool> dp(s.length()+1, false);
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (auto x : wordDict) {
                if (i < x.length()-1) { continue; }
                if (s.substr(i-(x.length()-1), x.length()) == x) {
                    dp[i+1] = dp[i+1] || dp[i+1-x.length()];
                }
            }
        }
        return dp[s.length()];
    }
};
