// Time Complexity: O(n^2)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

// Approach:
// 1. Create a set of words from the wordDict vector.
// 2. Create a dp map to store the result of the subproblems.
// 3. Start from the beginning of the string and check if the substring from start to i is present in the set.
// 4. If it is present, recursively check if the remaining string can be broken into words.
// 5. If the remaining string can be broken into words, return true.
// 6. If not, continue checking the next substring.
// 7. If no substring can be broken into words, return false.

class Solution {
    public:
        bool wordBreak(string s, vector<string>& wordDict) {
            unordered_set<string> set(wordDict.begin(), wordDict.end());
            unordered_map<int, bool> dp;
            return helper(s, 0, set, dp);
        }
    private: 
        bool helper(string s, int start, unordered_set<string>& set, unordered_map<int, bool>& dp){
            if(start == s.size()){
                return true;
            }
            if(dp.find(start) != dp.end()){
                return dp[start];
            }
            for(int i = start + 1; i <= s.size(); i++){
                if(set.find(s.substr(start, i - start)) != set.end() && helper(s, i, set, dp)){
                    return dp[start] = true;
                }
            }
            return dp[start] = false;
        }
    };