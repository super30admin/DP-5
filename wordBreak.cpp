// Time Complexity :O(n^3) where n is the length of the string s 
// Space Complexity : O(s) size of the hashset   
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        set<string> hSet;
        for(auto word : wordDict){
            hSet.insert(word);
        }
        vector<bool> dp(s.length()+1,false);
        dp[0] = true;
        for(int i = 1;i <= s.length();i++){
            for(int j= 0; j<i;j++){
                if(dp[j] == true && hSet.count(s.substr(j,i-j))){
                    dp[i] = true;
                    break;
                } 
            }
        }
        return dp[s.length()];
    }
};