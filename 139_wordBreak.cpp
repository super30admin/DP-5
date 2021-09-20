// Time Complexity : O(exponential)
// Space Complexity :O(N) where n is length of dictionary.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        if(wordDict.size() == 0 || s.length() == 0)
            return false;
        unordered_set<string> set (wordDict.begin(), wordDict.end());
        //for(string word : wordDict)
         //   set.insert(word);
        return helper(s, set);
    }
    
    bool helper(string s, unordered_set<string> set){
        //base
        if(s.length() == 0)
            return true;
        
        //logic
        for(int i=1; i<=s.length(); i++){
            if(set.find(s.substr(0,i)) != set.end() && helper(s.substr(i, s.length()-i+1), set)){
                return true;
            }
        }
        return false;
    }
};



// Time Complexity : O(N^4) where N is the length of dictionary
// Space Complexity :O(L)+O(NK) where L is length of string and N is the length of dictionary and K is average length of strings in dictionary.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        if(wordDict.size() == 0 || s.length() == 0)
            return false;
        unordered_set<string> set (wordDict.begin(), wordDict.end());
        int n = s.length();
        vector<bool> dp (n+1, false);
        dp[0] = true;
        for(int i=1; i<n+1; i++){
            for(int j=0; j<i; j++){
                if(dp[j]){
                    if(set.find(s.substr(j, i-j)) != set.end()){
                        dp[i] = true;
                        cout<<dp[i]<<" "<<i<<endl;
                        break;
                    }
                        
                }
            }
        }
        return dp[n];
    }
};
