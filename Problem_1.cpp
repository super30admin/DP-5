// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Word Break
// Approach: Dynamic Programming with HashSet
// Time Complexity: O(N^2)
// Space Complexity: O(N)

class Solution {
    private:
        unordered_set<string> set;
    
    public:
        bool wordBreak(string s, vector<string>& wordDict) {
            if (s.empty() || wordDict.empty()) {
                return false;
            }
    
            set = unordered_set<string>(wordDict.begin(), wordDict.end());
            int n = s.length();
            vector<bool> dp(n + 1, false);
            dp[0] = true;  
    
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j]) {  
                        if (set.find(s.substr(j, i - j)) != set.end()) {  
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
    
            return dp[n];  
        }
    };
    