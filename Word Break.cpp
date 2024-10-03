//time: O(n2)
//space: O(n)
class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> uset;
        for(string str : wordDict) {
            uset.insert(str);
        }
        int n = s.length();
        vector<bool> dp(n+1, false);
        dp[0] = true;
        for(int i = 0; i < n; i++) {
            string curr = "";
            int idx = i;
            while(idx >= 0) {
                curr = s[idx] + curr;
                
                if(dp[idx] == true) {
                    if(uset.find(curr) != uset.end()) {
                        dp[i+1] = true;
                        break;
                    }
                }
                idx--;
            }
        }
        return dp[n];
    }
};