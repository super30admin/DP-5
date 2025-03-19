// https://leetcode.com/problems/word-break/description/
// Time Complexity: O(n*m*k) where n is the length s, m is the length of the dictionary, and k is the avg length of the word
// Space Complexity: O(n)


class Solution {
    public:
        bool wordBreak(string s, vector<string>& wordDict) {
            int n = s.length();
            vector<bool> dp(n+1,false);
            dp[0] = true;
            for(int i=1; i<=n; i++){
                for(auto word : wordDict){
                    int start = i-word.length();
                    if(start >= 0 && dp[start] && (s.substr(start, word.length()) == word)){
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }
    };