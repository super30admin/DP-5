// Approach - Brute-Force
// Time Complexity -> O(n^n)
// Space Complexity -> O(n^n) 
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
    set<string> set2;
    private:
    bool helper(string str){
        // base
        if(str.length() == 0)
            return true;
        // logic
        for(int i = 0; i < str.length(); i++){
            string curr = str.substr(0, i+1);
            string rem = str.substr(i+1);
            if(set2.count(curr) && helper(rem))
                return true;
        }
        return false;
    }
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        set<string> set(wordDict.begin(), wordDict.end()); // If I choose to initialize my set here and not globally, I would have to pass it to my helper function.
        for(int i = 0; i < wordDict.size(); i++){
            set2.insert(wordDict[i]);
        }
        return helper(s);
    }
};

// Approach - DP
// Time Complexity -> O(n^3)
// Space Complexity -> O(n) 
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        set<string> set(wordDict.begin(), wordDict.end());
        vector<bool> dp(s.length()+1);
        dp[0] = true;
        for(int i = 1; i < dp.size(); i++){
            for(int j = 0; j < i; j++){
                string curr = s.substr(j, i-j);
                if(dp[j] && set.count(curr)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
};